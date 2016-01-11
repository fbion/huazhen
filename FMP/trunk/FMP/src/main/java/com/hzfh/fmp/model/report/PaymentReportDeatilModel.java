package com.hzfh.fmp.model.report;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.facade.report.PaymentReportDeatilFacade;
import com.hzfh.fmp.model.common.enumeration.PaymentExamineStatusType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PaymentReportDeatilModel {
    public static PagedList<PaymentReportDeatil> getPagingList(PaymentReportDeatilCondition paymentReportDeatilCondition) {
        return PaymentReportDeatilFacade.getPagingList(paymentReportDeatilCondition);
    }

    public static int add(PaymentReportDeatil paymentReportDeatil) {
        return PaymentReportDeatilFacade.add(paymentReportDeatil);
    }

    public static int update(PaymentReportDeatil paymentReportDeatil) {
        return PaymentReportDeatilFacade.update(paymentReportDeatil);
    }
    public static List<PaymentReportDeatil> getListByPaymentReportNo(int paymentReportNo){
        List<PaymentReportDeatil> paymentReportDeatilList = PaymentReportDeatilFacade.getListByPaymentReportNo(paymentReportNo);
        for(PaymentReportDeatil paymentReportDeatil:paymentReportDeatilList){
            PaymentRefund paymentRefund = PaymentRefundModel.getInfo(paymentReportDeatil.getPaymentNo());
            Sales sales = SalesModel.getInfo(paymentRefund.getSalesNo());
            Employee employee = EmployeeModel.getEmpByUserId(sales.getEmpNo());
            paymentReportDeatil.setEmpName(employee.getName());
            paymentReportDeatil.setDeptName(DepartmentModel.getInfo(paymentReportDeatil.getDeptNo()).getName());
            paymentReportDeatil.setProductName(ProductModel.getInfo(sales.getProductNo()).getName());
            if(paymentReportDeatil.getPayType()==0){
                paymentReportDeatil.setCustomerName(CustomerPersonalModel.getInfo(paymentReportDeatil.getCustomerNo()).getName());
            }
            if(paymentReportDeatil.getPayType()==1){
                paymentReportDeatil.setCustomerName(P2pCustomerModel.getInfo(paymentReportDeatil.getCustomerNo()).getRealName());
            }
        }
        return paymentReportDeatilList;
    }

    public static List<PaymentReportDeatil> getList() {
        return PaymentReportDeatilFacade.getList();
    }

    public static PaymentReportDeatil getInfo(int id) {
        return PaymentReportDeatilFacade.getInfo(id);
    }

    public static int addPaymentReportAndDetail(String honourDate,String paymentType,String activitiNo) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PaymentReport paymentReport = new PaymentReport();
        String type = "";
        if(paymentType.equals("honour")){
            type = String.valueOf(PaymentExamineStatusType.honour)+","+String.valueOf(PaymentExamineStatusType.principal)+","+String.valueOf(PaymentExamineStatusType.priAndInt);
            paymentReport.setType(1);
        }
        if(paymentType.equals("interest")){
            type = String.valueOf(PaymentExamineStatusType.interest);
            paymentReport.setType(0);
        }
        paymentReport.setPayDate(sdf.parse(honourDate));
        paymentReport.setActivitiNo(activitiNo);
        int id = PaymentReportModel.add(paymentReport);
        List<PaymentRefund> paymentRefundList =  PaymentRefundModel.getListByByHonourDateAndTypeAndStatus(honourDate, type, String.valueOf(PaymentExamineStatusType.CHECK));
        for(PaymentRefund paymentRefund:paymentRefundList){
            PaymentReportDeatilModel.add(getInfo(paymentRefund, id));
        }
        return 1;
    }

    public static PaymentReportDeatil getInfo(PaymentRefund paymentRefund,int paymentReportId){
        PaymentReportDeatil paymentReportDeatil = new PaymentReportDeatil();
        paymentReportDeatil.setPaymentReportNo(paymentReportId);
        Sales sales = SalesModel.getInfo(paymentRefund.getSalesNo());
        if(paymentRefund.getPayType()==0){
            CustomerPersonal customerPersonal = CustomerPersonalModel.getInfo(paymentRefund.getCustomerNo());
            paymentReportDeatil.setCardNumber(customerPersonal.getCardNumber());
            paymentReportDeatil.setCellphone(customerPersonal.getCellphone1());
        }
        if(paymentRefund.getPayType()==1){
            P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(paymentRefund.getP2pCustomerNo());
            paymentReportDeatil.setCardNumber(p2pCustomer.getCardNumber());
            paymentReportDeatil.setCellphone(p2pCustomer.getCellphone());
        }
        paymentReportDeatil.setPayType(paymentRefund.getPayType());
        paymentReportDeatil.setAccountNumber(sales.getAccountNumber());
        paymentReportDeatil.setAgentNo(sales.getEmpNo());
        paymentReportDeatil.setBankAddress(sales.getBankAddress());
        paymentReportDeatil.setPaymentNo(paymentRefund.getId());
        paymentReportDeatil.setCustomerNo(paymentRefund.getCustomerNo());
        paymentReportDeatil.setDeptNo(EmployeeModel.getEmpByUserId(sales.getEmpNo()).getDeptNo());
        paymentReportDeatil.setIncome(sales.getIncome());
        paymentReportDeatil.setInterest(paymentRefund.getInterest());
        paymentReportDeatil.setPayDate(paymentRefund.getActualPayTime());
        paymentReportDeatil.setPayMoney(paymentRefund.getPayMoney());
        paymentReportDeatil.setProductNo(sales.getProductNo());
        paymentReportDeatil.setPurchaseDate(sales.getPurchaseDate());
        paymentReportDeatil.setRepaymentDate(sales.getRepaymentDate());
        paymentReportDeatil.setSalesMoney(sales.getMoney());
        paymentReportDeatil.setInUserNo(UserHelper.getUserCache().getUserId());
        return paymentReportDeatil;
    }

    public static List<PaymentReportDeatil> getListByReportNo(int reportNo) {
        return PaymentReportDeatilFacade.getListByReportNo(reportNo);
    }
}
