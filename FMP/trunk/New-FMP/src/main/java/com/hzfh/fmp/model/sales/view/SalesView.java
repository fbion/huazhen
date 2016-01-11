package com.hzfh.fmp.model.sales.view;

import com.hzfh.api.sales.model.Sales;

/**
 * Created by paul on 15-4-29.
 */
public class SalesView extends Sales {
    public SalesView(Sales sales) {
    	this.setAccountNumber(sales.getAccountNumber());
    	this.setAgentRate(sales.getAgentRate());
    	this.setAgentRateReal(sales.getAgentRateReal());
    	this.setBankAddress(sales.getBankAddress());
    	this.setBankcardPath(sales.getBankcardPath());
    	this.setBankName(sales.getBankName());
        this.setCode(sales.getCode());
        this.setContractCode(sales.getContractCode());
        this.setContractPath(sales.getContractPath());
        this.setCustomerNo(sales.getCustomerNo());
        this.setCustomerType(sales.getCustomerType());
        this.setDeptNo(sales.getDeptNo());
        this.setDocumentPath(sales.getDocumentPath());
        this.setEditComment(sales.getEditComment());
        this.setEditTime(sales.getEditTime());
        this.setEditUserNo(sales.getEditUserNo());
        this.setEmpNo(sales.getEmpNo());
        this.setId(sales.getId());
        this.setIdcardPath(sales.getIdcardPath());
        this.setIncomeMoney(sales.getIncomeMoney());
        this.setIncomeRate(sales.getIncomeRate());
        this.setIncomeRateReal(sales.getIncomeRateReal());
        this.setInTime(sales.getInTime());
        this.setInUserNo(sales.getInUserNo());
        this.setIsTest(sales.getIsTest());
        this.setMoney(sales.getMoney());
        this.setPeopleNo(sales.getPeopleNo());
        this.setPeopleType(sales.getProductType());
        this.setProductNo(sales.getProductNo());
        this.setProductStagesNo(sales.getProductStagesNo());
        this.setProductType(sales.getProductType());
        this.setProtocolStatus(sales.getProtocolStatus());
        this.setPurchaseDate(sales.getPurchaseDate());
        this.setStatus(sales.getStatus());
        this.setVoucherPath(sales.getVoucherPath());
        this.setRepaymentDate(sales.getRepaymentDate());
    }
    private String manageString;
    private String productTypeString;
    private String productString;
    private String customerTypeString;
    private String customerString;
    private String peopleTypeString;
    private String peopleString;
    private String orderStatusString;
    private String departmentString;
    private String decisionTypeString;
    private String repaymentDate;
    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getManageString() {
		return manageString;
	}
	public void setManageString(String manageString) {
		this.manageString = manageString;
	}
	public String getProductTypeString() {
		return productTypeString;
	}
	public void setProductTypeString(String productTypeString) {
		this.productTypeString = productTypeString;
	}
	public String getProductString() {
		return productString;
	}
	public void setProductString(String productString) {
		this.productString = productString;
	}
	public String getCustomerTypeString() {
		return customerTypeString;
	}
	public void setCustomerTypeString(String customerTypeString) {
		this.customerTypeString = customerTypeString;
	}
	public String getCustomerString() {
		return customerString;
	}
	public void setCustomerString(String customerString) {
		this.customerString = customerString;
	}
	public String getPeopleTypeString() {
		return peopleTypeString;
	}
	public void setPeopleTypeString(String peopleTypeString) {
		this.peopleTypeString = peopleTypeString;
	}
	public String getPeopleString() {
		return peopleString;
	}
	public void setPeopleString(String peopleString) {
		this.peopleString = peopleString;
	}
	public String getOrderStatusString() {
		return orderStatusString;
	}
	public void setOrderStatusString(String orderStatusString) {
		this.orderStatusString = orderStatusString;
	}
	public String getDepartmentString() {
		return departmentString;
	}
	public void setDepartmentString(String departmentString) {
		this.departmentString = departmentString;
	}
	public String getDecisionTypeString() {
		return decisionTypeString;
	}
	public void setDecisionTypeString(String decisionTypeString) {
		this.decisionTypeString = decisionTypeString;
	}
	
	
	
	
	
	
	
	
	
   
}
