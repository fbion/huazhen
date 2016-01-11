package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PaymentAccountOper extends BaseEntity implements Serializable {
	private String customerNo;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private byte accountType;
	public byte getAccountType() {
		return accountType;
	}
	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}
	private byte operType;
	public byte getOperType() {
		return operType;
	}
	public void setOperType(byte operType) {
		this.operType = operType;
	}
	private Timestamp timeCreate;
	public Timestamp getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Timestamp timeCreate) {
		this.timeCreate = timeCreate;
	}
	private String operator;
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	private String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}