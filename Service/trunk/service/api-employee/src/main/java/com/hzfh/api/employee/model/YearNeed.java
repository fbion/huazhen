package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class YearNeed extends BaseEntity implements Serializable {
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
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
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
	private int rowspanNo;
	public int getRowspanNo() {
		return rowspanNo;
	}
	public void setRowspanNo(int rowspanNo) {
		this.rowspanNo = rowspanNo;
	}
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	private int yearNeedTotalNo;
	public int getYearNeedTotalNo() {
		return yearNeedTotalNo;
	}
	public void setYearNeedTotalNo(int yearNeedTotalNo) {
		this.yearNeedTotalNo = yearNeedTotalNo;
	}
	
	
}