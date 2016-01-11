package com.hzfh.p2p.controller.product.ajax;


import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.CardStatus;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.ServiceStates;
import com.hzfh.api.payment.model.common.constant.UserType;
import com.hzfh.api.payment.model.common.entity.Detail;
import com.hzfh.api.payment.model.common.entity.Details;
import com.hzfh.api.payment.model.common.entity.Tender;
import com.hzfh.api.payment.model.request.gateway.CpTransactionReq;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.baseInfo.EmployeeModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;
import com.hzfh.p2p.model.payment.GatewayModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzfh.p2p.model.sales.ContractModel;
import com.hzfh.p2p.model.sales.SalesModel;
import com.hzframework.helper.DateHelper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/11.
 */
public class AjaxPaymentConfirm extends CommonAction {
    private static final LogHelper logger = LogHelper.getLogger(AjaxPaymentConfirm.class.getName());
    private String p2pProductNo;
    private String verifyCode;
    private String investmentMoney;
    private String message;

    public void setP2pProductNo(String p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setInvestmentMoney(String investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public String getInvestmentMoney() {
        return investmentMoney;
    }

    public String getP2pProductNo() {
        return p2pProductNo;
    }

    public String getMessage() {
        return message;
    }

    private PaymentData paymentData;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    private int contractNo;
    public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	@Override
    public String execute() {
        logger.info("支付金额操作");
        if (!CharacterFilter.isVaildVerifyCode(verifyCode)) {
            this.message = "error";
            return SUCCESS;
        }
        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {
            this.message = "error";
            return SUCCESS;
        }
        P2pProduct p2pProduct = P2pProductModel.getInfo(Integer.parseInt(this.p2pProductNo));
        
        

        Sales sales = new Sales();
        sales.setContractCode(ContractModel.getInfo(contractNo).getCode());
        sales.setProductType((byte) 5);
        sales.setProductNo(p2pProduct.getProductNo());
        sales.setP2pProductName(p2pProduct.getName());
        sales.setP2pProductNo(Integer.valueOf(this.p2pProductNo));
        sales.setStatus(PaymentType.PAYMENT_PAYMENTING);//付款中   notify修改为待审核
        sales.setMoney(Long.valueOf(this.investmentMoney));
        sales.setPurchaseDate(DateHelper.getTodayDate());
        //sales.setCustomerType((byte)4);
        sales.setP2pCustomerNo(StateValues.getCustomerId());
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(StateValues.getCustomerId());
        sales.setEmpNo(p2pCustomer.getEmpNo());
        sales.setDeptNo(p2pCustomer.getDeptNo());
        Employee employee = EmployeeModel.getInfo(p2pCustomer.getEmpNo());
        if(employee!=null){
        	sales.setEmpName(employee.getName());
        }
        sales.setProtocolStatus((byte) 3);
        sales.setPeopleType((byte) 5);
        sales.setCustomerType((byte) 3);
        sales.setCustomerName(p2pCustomer.getRealName());
        sales.setPurchaseDate(DateHelper.getTodayDate());
        sales.setPayType(PaymentType.SALESPAY_ONLINE);
        
        sales.setIncome((int)p2pProduct.getIncome());
        sales.setEstablishDate(new java.sql.Date(p2pProduct.getStart().getTime()));
        sales.setRepaymentDate(new java.sql.Date(p2pProduct.getEnd().getTime()));
        
        //Product product = ProductModel.getInfo(p2pProduct.getProductNo());
        //sales.setPaymentType(product.getPayType());
        sales.setPaymentType(p2pProduct.getRepaymentIssue());
        
        int salesNo;
		salesNo = SalesModel.add(sales);

        CpTransactionReq<Tender> cpTransactionReq = new CpTransactionReq<Tender>();
        cpTransactionReq.setRequestNo(String.valueOf(salesNo));
        cpTransactionReq.setPlatformUserNo(String.valueOf(StateValues.getCustomerId()));
        cpTransactionReq.setUserType(CardStatus.MEMBER.toString());
        cpTransactionReq.setBizType(ServiceStates.TENDER.toString());
//      cpTransactionReq.setExpired(DateHelper.addDay(sales.getPurchaseDate(), 3).toString());

        List<Detail> detailList = new ArrayList<Detail>();

        Detail detail = new Detail();

        detail.setAmount(this.investmentMoney);
        detail.setBizType(ServiceStates.TENDER.toString());
        detail.setTargetPlatformUserNo(String.valueOf(p2pProduct.getBorrowerUserNo()));
        detail.setTargetUserType(CardStatus.MEMBER.toString());
        detailList.add(detail);

        Details details = new Details();
        details.setDetails(detailList);
        cpTransactionReq.setDetails(details);
        cpTransactionReq.setRemark("您投标的产品名称为："+p2pProduct.getName());
        Tender tender = new Tender();
        tender.setTenderOrderNo(String.valueOf(p2pProduct.getId()));
        tender.setTenderName(p2pProduct.getName());
        tender.setTenderAmount(String.valueOf(p2pProduct.getTotalAmout()));
        tender.setTenderDescription(p2pProduct.getName());
        tender.setBorrowerPlatformUserNo(String.valueOf(p2pProduct.getBorrowerUserNo()));
        cpTransactionReq.setExtend(tender.getExtend());
        cpTransactionReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("product/tenderNotify"));
        cpTransactionReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("product/tenderCallback"));
        cpTransactionReq.setPlatformNo(cpTransactionReq.getPlatformNo());
        try{
            this.paymentData = GatewayModel.tender(cpTransactionReq);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ExamineCallbackRecord examineCallbackRecord = new ExamineCallbackRecord();
		examineCallbackRecord.setSn(String.valueOf(salesNo));
		examineCallbackRecord.setServiceName(QueryType.QUERY_CP_TRANSACTION);
		examineCallbackRecord.setStatus(QueryType.QUERY_NO_NOTIFY);
		examineCallbackRecord.setOperationType(QueryType.QUERY_TENDER);
		examineCallbackRecord.setComment("投标");
		ExamineCallbackRecordModel.add(examineCallbackRecord);
        return SUCCESS;
    }
}
