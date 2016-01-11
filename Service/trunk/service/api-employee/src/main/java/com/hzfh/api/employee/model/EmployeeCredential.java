package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmployeeCredential extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String credential;
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	private Date credentialDate;
	public Date getCredentialDate() {
		return credentialDate;
	}
	public void setCredentialDate(Date credentialDate) {
		this.credentialDate = credentialDate;
	}
}