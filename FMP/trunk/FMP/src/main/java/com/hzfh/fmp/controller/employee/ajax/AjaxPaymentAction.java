package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.PaymentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxPaymentAction extends JqGridBaseAction<Payment> {
    
	private String position;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	private String award;
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	private String allowance;
	public String getAllowance() {
		return allowance;
	}
	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}
	private String travel;
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	private String salary;
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private String salarydate;
	public String getSalarydate() {
		return salarydate;
	}
	public void setSalarydate(String salarydate) {
		this.salarydate = salarydate;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

    @Override
    public String execute() throws Exception{
    	PaymentCondition paymentCondition = new PaymentCondition();
        paymentCondition.setPageSize(this.getPageSize());
        paymentCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        paymentCondition.setSortItemList(sortItemList);

        PagedList<Payment> paymentPagedList= PaymentModel.getPagingList(paymentCondition);
        this.setResultList(paymentPagedList.getResultList());
        this.setPageCount(paymentPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(paymentPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(paymentPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Payment payment = new Payment();
        
		payment.setPosition(Double.parseDouble(this.position));
		payment.setAward(Double.parseDouble(this.award));
		payment.setAllowance(Double.parseDouble(this.allowance));
		payment.setTravel(Double.parseDouble(this.travel));
		payment.setSalary(Double.parseDouble(this.salary));
		payment.setComment(this.comment);
		payment.setSalarydate(Timestamp.valueOf(this.salarydate));
		payment.setEmpNo(Integer.parseInt(this.empNo));
		payment.setEditComment(this.getEditComment());
		payment.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	payment.setInUserNo(UserHelper.getEditUserNo());
            if (PaymentModel.add(payment )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    payment.setId(Integer.parseInt(this.getId()));
                    if (PaymentModel.update(payment) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
