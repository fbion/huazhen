package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class DeptYearNeed extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int financialYear;
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	private int deptNo;
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String string) {
		this.deptName = deptName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private int nowEmpTotal;
	public int getNowEmpTotal() {
		return nowEmpTotal;
	}
	public void setNowEmpTotal(int nowEmpTotal) {
		this.nowEmpTotal = nowEmpTotal;
	}
	private int addEmpTotal;
	public int getAddEmpTotal() {
		return addEmpTotal;
	}
	public void setAddEmpTotal(int addEmpTotal) {
		this.addEmpTotal = addEmpTotal;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
	private int workFlowStatus;
	public int getWorkFlowStatus() {
		return workFlowStatus;
	}
	public void setWorkFlowStatus(int workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}
	
}