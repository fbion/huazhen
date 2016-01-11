package com.hzfh.fmp.controller.payment.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.CardStatus;
import com.hzfh.api.payment.model.common.constant.ServiceStates;
import com.hzfh.api.payment.model.common.constant.TransferStatus;
import com.hzfh.api.payment.model.common.entity.Detail;
import com.hzfh.api.payment.model.common.entity.Details;
import com.hzfh.api.payment.model.common.entity.Repayment;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.model.request.controller.CompleteTransactionReq;
import com.hzfh.api.payment.model.request.gateway.CpTransactionReq;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.common.enumeration.PaymentExamineStatusType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;
import com.hzfh.fmp.model.payment.ControllerModel;
import com.hzfh.fmp.model.payment.GatewayModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;
import net.hydromatic.linq4j.function.DoubleFunction1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class AjaxPaymentRefundAction extends JqGridBaseAction<PaymentRefund> {
    public static final LogHelper logger = LogHelper.getLogger(AjaxPaymentRefundAction.class);
    private PaymentRefund info;

    public PaymentRefund getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PaymentRefund.class);
    }

    private PaymentData paymentData;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    private String byP2pProduct;
    private String byStatus;
    private String byStartRepayIssue;
    private String byEndRepayIssue;
    private String byPayType;
    private String smsStatus;
    private String showAllList;
    private int salesNo;
    private String smsContent;
    private String cellphone;

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public int getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public void setByPayType(String byPayType) {
        this.byPayType = byPayType;
    }

    public void setByStartRepayIssue(String byStartRepayIssue) {
        this.byStartRepayIssue = byStartRepayIssue;
    }

    public void setByEndRepayIssue(String byEndRepayIssue) {
        this.byEndRepayIssue = byEndRepayIssue;
    }

    public void setByP2pProduct(String byP2pProduct) {
        this.byP2pProduct = byP2pProduct;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentRefundCondition getCondition(){
        PaymentRefundCondition paymentRefundCondition = new PaymentRefundCondition();
        paymentRefundCondition.setPageSize(this.getPageSize());
        paymentRefundCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            paymentRefundCondition.setSalesNos(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            String workMateString = "";
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                workMateString = StringHelper.listToString(workmate);
            }else{
                workMateString = String.valueOf(UserHelper.getUserCache().getUserId());
            }
            List<Sales> salesList =  SalesModel.getListByEmps(workMateString);
            List<Integer> salesNos = new ArrayList<Integer>();
            for(Sales sales:salesList){
                salesNos.add(sales.getId());
            }
            paymentRefundCondition.setSalesNos(StringHelper.listToString(salesNos));
        }

        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
            paymentRefundCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        } else {
            paymentRefundCondition.setIsTest((byte) 0);
        }
        if (!StringHelper.isNullOrEmpty(this.byP2pProduct)) {
            paymentRefundCondition.setP2pProductNo(Integer.valueOf(this.byP2pProduct));
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
            paymentRefundCondition.setStatus(Byte.valueOf(this.byStatus));
        }
        if(!StringHelper.isNullOrEmpty(this.byStartRepayIssue)){
            paymentRefundCondition.setByStartRepayIssue(this.byStartRepayIssue);
        }
        if(!StringHelper.isNullOrEmpty(this.byEndRepayIssue)){
            paymentRefundCondition.setByEndRepayIssue(this.byEndRepayIssue);
        }
        if(!StringHelper.isNullOrEmpty(this.smsStatus)){
            paymentRefundCondition.setSmsStatus(Integer.parseInt(this.smsStatus));
        }else{
            paymentRefundCondition.setSmsStatus(-1);
        }
        if(!StringHelper.isNullOrEmpty(this.byPayType)){
            paymentRefundCondition.setPayType(Byte.valueOf(this.byPayType));
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        paymentRefundCondition.setSortItemList(sortItemList);
        return paymentRefundCondition;
    }

    @Override
    public String execute() throws Exception {
        PagedList<PaymentRefund> paymentRefundPagedList = PaymentRefundModel.getPagingList(this.getCondition());
        List<PaymentRefund> list = new ArrayList<PaymentRefund>();
        list=paymentRefundPagedList.getResultList();
    	PaymentRefund paymentRefund = new PaymentRefund();
    	P2pProduct p2pProduct = new P2pProduct();
    	Product product =new Product();
        for (int i = 0; i < list.size(); i++) {
        	paymentRefund=list.get(i);
        	if(paymentRefund.getProductType()==5){
        		p2pProduct=P2pProductModel.getP2pByProductNo(paymentRefund.getProductNo());
        		if(p2pProduct!=null){
                	list.get(i).setEditComment(p2pProduct.getName());
        		}else{
        			list.get(i).setEditComment("");
        		}
        	}else{
        		product=ProductModel.getInfo(paymentRefund.getProductNo());
        		if(product!=null){
                	list.get(i).setEditComment(product.getName());
        		}else{
                	list.get(i).setEditComment("");
        		}
        	}
		}
        this.setResultList(list);
        this.setPageCount(paymentRefundPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(paymentRefundPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(paymentRefundPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String ajaxExportExcel(){
        ExcelHelper excelHelper =  new ExcelHelper();
        excelHelper.getExcelForPaymentRefund(this.getCondition());
        return null;
    }
    public String getPayMoneyBySalesNo(){

        if (StringHelper.isNullOrEmpty(String.valueOf(this.salesNo))) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = PaymentRefundModel.getHonourBySalesNo(this.salesNo);
            String[] a = String.valueOf(this.info.getPayMoney()).split("\\.");
            if(Integer.parseInt(a[1])!=0){
                this.info.setPayMoney(Integer.valueOf(a[0])+1);
            }
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        return SUCCESS;

    }
    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = PaymentRefundModel.add(info);
            if (id > 0) {
                this.setErrDesc(String.valueOf(id));
            } else {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    PaymentRefund paymentRefund = PaymentRefundModel.getInfo(info.getId());
                    info.setSalesNo(paymentRefund.getSalesNo());
                    info.setP2pProductNo(paymentRefund.getP2pProductNo());
                    //info.setP2pCustomerNo(paymentRefund.getP2pCustomerNo());
                    info.setCustomerNo(paymentRefund.getCustomerNo());
                    info.setPayerNo(paymentRefund.getPayerNo());
                    if (PaymentRefundModel.update(info) > 0) {
                        this.setErrDesc(String.valueOf(info.getId()));
                    } else {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }

        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = PaymentRefundModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

    public String refundPayment() {
        logger.info("确认还款操作");
        CustomerCompany customerCompany = CustomerCompanyModel.getInfoByP2pCustomerNo(this.info.getPayerNo());
        PaymentAccountInformation payer = PaymentAccountInformationModel.getInfoByCustomerNo(customerCompany.getP2pCustomerNo());
        if (payer == null) {
            this.setErrDesc("此付款方尚未注册易宝平台账户");
            this.setErrCode("paymentAccountInformation is null");
            logger.error("此付款方尚未注册易宝平台账户");
            return SUCCESS;
        }
        PaymentAccountInformation payee = PaymentAccountInformationModel.getInfoByCustomerNo(this.info.getP2pCustomerNo());
        if (payee == null) {
            this.setErrDesc("此收款方尚未注册易宝平台账户");
            this.setErrCode("accountInformation is null");
            logger.error("此收款方尚未注册易宝平台账户");
            return SUCCESS;
        }
        CpTransactionReq<Repayment> cpTransactionReq = new CpTransactionReq<Repayment>();
        cpTransactionReq.setRequestNo(String.valueOf(this.info.getId()));
        cpTransactionReq.setPlatformNo("default");
        cpTransactionReq.setPlatformUserNo(String.valueOf(customerCompany.getP2pCustomerNo()));
        cpTransactionReq.setUserType(String.valueOf(CardStatus.MEMBER));
        cpTransactionReq.setBizType(String.valueOf(ServiceStates.REPAYMENT));
//        cpTransactionReq.setExpired(String.valueOf(this.info.getPayEndTime()));
        Detail detail = new Detail();
        detail.setAmount(String.valueOf(this.info.getPayMoney()));
        detail.setTargetUserType(String.valueOf(CardStatus.MEMBER));
        detail.setTargetPlatformUserNo(String.valueOf(this.info.getP2pCustomerNo()));
        detail.setBizType(String.valueOf(ServiceStates.REPAYMENT));
        List<Detail> detailList = new ArrayList<>();
        detailList.add(detail);
        Details details = new Details();
        details.setDetails(detailList);
        cpTransactionReq.setDetails(details);

        Repayment repayment = new Repayment();
        repayment.setTenderOrderNo(String.valueOf(this.info.getP2pProductNo()));
        cpTransactionReq.setExtend(repayment.getExtend());
        cpTransactionReq.setNotifyUrl(UrlHelper.buildPaymentSiteUrl("/payment/paymentRefund/repaymentNotify"));
        cpTransactionReq.setCallbackUrl(UrlHelper.buildPaymentSiteUrl("/payment/paymentRefund/repaymentCallback"));
        cpTransactionReq.setRemark("还款操作");
        try {
            this.paymentData = GatewayModel.repayment(cpTransactionReq);
        } catch (Exception e) {
            logger.error("还款操作出现异常", e);
        }
        return SUCCESS;
    }

    public String checkPayment() {
        logger.info("审核还款操作");
        try {
            CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
            completeTransactionReq.setPlatformNo("default");
            completeTransactionReq.setRequestNo(String.valueOf(this.getId()));
            completeTransactionReq.setMode(TransferStatus.CONFRIM);
            completeTransactionReq.setNotifyUrl(UrlHelper.buildPaymentSiteUrl("/payment/paymentRefund/confirmTransactionNotify"));
            ControllerModel.getCompleteTransaction(completeTransactionReq);
        } catch (Exception e) {
            logger.error("审核还款确认出现异常", e);
            this.setErrCode("failed");
        }

        return SUCCESS;
    }

    public String cancelRefundPayment() {
        logger.info("取消还款确认操作");
        try {
            CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
            completeTransactionReq.setPlatformNo("default");
            completeTransactionReq.setRequestNo(String.valueOf(this.getId()));
            completeTransactionReq.setMode(TransferStatus.CANCEL);
            completeTransactionReq.setNotifyUrl(UrlHelper.buildPaymentSiteUrl("/payment/paymentRefund/cancelTransactionNotify"));
            ControllerModel.getCompleteTransaction(completeTransactionReq);
        } catch (Exception e) {
            logger.error("还款转账确认出现异常", e);
            this.setErrCode("failed");
        }
        return SUCCESS;
    }

    public String getContent(){
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoId");
            return SUCCESS;
        } else {
            PaymentRefund paymentRefund = PaymentRefundModel.getInfo(Integer.parseInt(this.getId()));
            String productName = P2pProductModel.getInfo(paymentRefund.getP2pProductNo()).getName();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String content = "";
            if(paymentRefund.getPaymentType()==0){
                content = SmsModel.smsProductInterest(sdf.format(paymentRefund.getActualPayTime()),productName, Double.toString(paymentRefund.getPayMoney()),String.valueOf(paymentRefund.getTimes()));
            }
            if(paymentRefund.getPaymentType()==1){
                content = SmsModel.smsProductExpire(sdf.format(paymentRefund.getActualPayTime()),productName, Double.toString(paymentRefund.getPayMoney()));
            }
            if(paymentRefund.getPaymentType()==2){
                content = SmsModel.smsContinueInvestment(sdf.format(paymentRefund.getActualPayTime()),productName,
                        String.valueOf(paymentRefund.getInterest()),String.valueOf(paymentRefund.getSalesMoney()));
            }
            if(paymentRefund.getPaymentType()==3){
                content = SmsModel.smsContinueInvestmentInterest(sdf.format(paymentRefund.getActualPayTime()), productName,
                        String.valueOf(MathHelper.add(paymentRefund.getSalesMoney(),paymentRefund.getInterest())));
            }
            String cellphone = "";
            try{
                if(paymentRefund.getPayType()==1){
                    cellphone = P2pCustomerModel.getInfo(paymentRefund.getP2pCustomerNo()).getCellphone();
                }else{
                    cellphone = CustomerPersonalModel.getInfo(paymentRefund.getCustomerNo()).getCellphone1();
                }
            }catch (Exception e){
                this.cellphone = "没有手机号";
            }

            this.smsContent = content;
            this.cellphone = cellphone;
        }
        return SUCCESS;
    }

    public String sendSms(){
        PaymentRefund paymentRefund = PaymentRefundModel.getInfo(Integer.parseInt(this.getId()));
        if(SmsModel.addSms(this.smsContent,this.cellphone)>0){
            this.setErrCode("0000");
            this.setErrDesc("操作成功");
            paymentRefund.setIsSendSms(2);
            PaymentRefundModel.update(paymentRefund);
            if(paymentRefund.getTimes()==PaymentRefundModel.getTimesIsUseBySalesNo(paymentRefund.getSalesNo())){
                SalesModel.updateStatus(paymentRefund.getSalesNo(), SalesStatus.payment);
            }
        }else{
            this.setErrCode("操作失败");
            this.setErrDesc("操作失败");
        }
        return SUCCESS;
    }
    private String honourDate;
    private String paymentType;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getHonourDate() {
        return honourDate;
    }

    public void setHonourDate(String honourDate) {
        this.honourDate = honourDate;
    }

    public String getListByDate(){
        if(this.paymentType.equals("honour")){
            type = String.valueOf(PaymentExamineStatusType.honour)+","+String.valueOf(PaymentExamineStatusType.principal)+","+String.valueOf(PaymentExamineStatusType.priAndInt);
        }
        if(this.paymentType.equals("interest")){
            type = String.valueOf(PaymentExamineStatusType.interest);
        }
        List<PaymentRefund> paymentRefundList = PaymentRefundModel.getListByByHonourDateAndTypeAndStatus(this.honourDate,type, String.valueOf(PaymentExamineStatusType.CHECK));
        if(paymentRefundList.size()<=0){
            this.setErrCode("没有数据，请重新选择");
            this.setErrDesc("没有数据，请重新选择");
        }
        return SUCCESS;
    }

}
