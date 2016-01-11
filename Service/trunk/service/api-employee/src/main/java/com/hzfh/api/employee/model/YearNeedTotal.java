package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class YearNeedTotal extends BaseEntity implements Serializable {
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
	private int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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