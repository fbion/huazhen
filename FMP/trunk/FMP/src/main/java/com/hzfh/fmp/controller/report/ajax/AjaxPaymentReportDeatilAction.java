package com.hzfh.fmp.controller.report.ajax;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.PaymentExamineStatusType;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.report.PaymentReportDeatilModel;
import com.hzfh.fmp.model.report.PaymentReportModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AjaxPaymentReportDeatilAction extends JqGridBaseAction<PaymentReportDeatil> {
    private List<PaymentRefund> paymentRefundList;
    private List<PaymentReportDeatil> paymentReportDeatilList;
    private String honourDate;
    private String paymentType;
    private int paymentReportId;
    private String title;
    private String showCardNumberAndCellphone;
    private String activitiNo;

    public String getActivitiNo() {
		return activitiNo;
	}

	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}

	public String getShowCardNumberAndCellphone() {
        return showCardNumberAndCellphone;
    }

    public void setShowCardNumberAndCellphone(String showCardNumberAndCellphone) {
        this.showCardNumberAndCellphone = showCardNumberAndCellphone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPaymentReportId() {
        return paymentReportId;
    }

    public void setPaymentReportId(int paymentReportId) {
        this.paymentReportId = paymentReportId;
    }

    public List<PaymentRefund> getPaymentRefundList() {
        return paymentRefundList;
    }

    public void setPaymentRefundList(List<PaymentRefund> paymentRefundList) {
        this.paymentRefundList = paymentRefundList;
    }

    public String getHonourDate() {
        return honourDate;
    }

    public void setHonourDate(String honourDate) {
        this.honourDate = honourDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentReportDeatil> getPaymentReportDeatilList() {
        return paymentReportDeatilList;
    }

    public void setPaymentReportDeatilList(List<PaymentReportDeatil> paymentReportDeatilList) {
        this.paymentReportDeatilList = paymentReportDeatilList;
    }

    public String ajaxListPaymentReportByPaymentReportId(){
        PaymentReport paymentReport = PaymentReportModel.getInfo(this.paymentReportId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String payDate = simpleDateFormat.format(paymentReport.getPayDate());
        if(paymentReport.getType()==0){
            this.title = payDate+"付息明细表";
        }
        if(paymentReport.getType()==1){
            this.title = payDate+"还本付息明细表";
        }
        this.paymentReportDeatilList = PaymentReportDeatilModel.getListByPaymentReportNo(this.paymentReportId);
        return SUCCESS;
    }
    public String ajaxListPaymentReportByHonourDate(){
        String type = "";
        if(this.paymentType.equals("honour")){
            this.title = this.honourDate+"还本付息明细表";
            type = String.valueOf(PaymentExamineStatusType.honour)+","+String.valueOf(PaymentExamineStatusType.principal)+","+String.valueOf(PaymentExamineStatusType.priAndInt);
        }
        if(this.paymentType.equals("interest")){
            this.title = this.honourDate+"付息明细表";
            type = String.valueOf(PaymentExamineStatusType.interest);
        }
        this.paymentRefundList = PaymentRefundModel.getListByByHonourDateAndTypeAndStatus(this.honourDate,type, String.valueOf(PaymentExamineStatusType.CHECK));

        List<PaymentReportDeatil> paymentReportDeatils = new ArrayList<PaymentReportDeatil>();
        for(PaymentRefund paymentRefund:paymentRefundList){
            paymentReportDeatils.add(getInfo(paymentRefund));
        }
        this.paymentReportDeatilList = paymentReportDeatils;
        return SUCCESS;
    }

    public PaymentReportDeatil getInfo(PaymentRefund paymentRefund){
        PaymentReportDeatil paymentReportDeatil = new PaymentReportDeatil();
        Sales sales = SalesModel.getInfo(paymentRefund.getSalesNo());
        if(paymentRefund.getPayType()==0){
            CustomerPersonal customerPersonal = CustomerPersonalModel.getInfo(paymentRefund.getCustomerNo());
            paymentReportDeatil.setCardNumber(customerPersonal.getCardNumber());
            paymentReportDeatil.setCellphone(customerPersonal.getCellphone1());
            paymentReportDeatil.setCustomerName(customerPersonal.getName());
        }
        if(paymentRefund.getPayType()==1){
            P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(paymentRefund.getP2pCustomerNo());
            paymentReportDeatil.setCardNumber(p2pCustomer.getCardNumber());
            paymentReportDeatil.setCellphone(p2pCustomer.getCellphone());
            paymentReportDeatil.setCustomerName(p2pCustomer.getRealName());
        }
        Employee employee = EmployeeModel.getEmpByUserId(sales.getEmpNo());
        paymentReportDeatil.setProductNo(sales.getProductNo());
        paymentReportDeatil.setProductName(ProductModel.getInfo(sales.getProductNo()).getName());
        paymentReportDeatil.setEmpName(employee.getName());
        paymentReportDeatil.setDeptNo(employee.getDeptNo());
        paymentReportDeatil.setDeptName(DepartmentModel.getInfo(employee.getDeptNo()).getName());
        paymentReportDeatil.setId(paymentRefund.getId());
        paymentReportDeatil.setAccountNumber(sales.getAccountNumber());
        paymentReportDeatil.setAgentNo(sales.getEmpNo());
        paymentReportDeatil.setBankAddress(sales.getBankAddress());
        paymentReportDeatil.setPaymentNo(paymentRefund.getId());
        paymentReportDeatil.setCustomerNo(paymentRefund.getCustomerNo());
        paymentReportDeatil.setIncome(sales.getIncome());
        paymentReportDeatil.setInterest(paymentRefund.getInterest());
        paymentReportDeatil.setPayMoney(paymentRefund.getPayMoney());

        paymentReportDeatil.setSalesMoney(sales.getMoney());
        paymentReportDeatil.setInUserNo(UserHelper.getUserCache().getUserId());


        paymentReportDeatil.setPayDate(paymentRefund.getActualPayTime());
        paymentReportDeatil.setPurchaseDate(sales.getPurchaseDate());
        paymentReportDeatil.setRepaymentDate(sales.getRepaymentDate());

        return paymentReportDeatil;
    }
    public String addDetailAndUpdateReport(){
    	try {
        	PaymentReportDeatilModel.addPaymentReportAndDetail(honourDate, paymentType, activitiNo);
        	PaymentReport report = PaymentReportModel.getInfoByActivitiNo(activitiNo);
        	if(report!=null){
        		List<PaymentReportDeatil> list =PaymentReportDeatilModel.getListByReportNo(report.getId());
        		if(list.size()>0){
        			String ids = "";
        			for (PaymentReportDeatil paymentReportDeatil : list) {
        				ids = ids+paymentReportDeatil.getId()+",";
					}
    				PaymentRefundModel.updateExamineStatusByIds(ids.substring(0, ids.length()-1), 1);
        		}
        		
        		ActHiProcinst procinst = new ActHiProcinst();
            	procinst = ActHiProcinstModel.getInfo(Integer.parseInt(activitiNo));
            	if(procinst !=null){
            		procinst.setBusinessKey(procinst.getBusinessKey().split("\\?")[0]+"?paymentReportId="+report.getId()+"&activitiNo=");
            		ActHiProcinstModel.update(procinst);
            	}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return SUCCESS;
    }
}
