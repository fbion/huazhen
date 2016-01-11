package com.hzfh.api.customer.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

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


public class PaymentMoneyWithdrawCondition extends QueryCondition implements Serializable {
	private int customerNo;

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	
	private String dateUp;
	private String dateDown;

	public String getDateUp() {
		return dateUp;
	}

	public void setDateUp(String dateUp) {
		this.dateUp = dateUp;
	}

	public String getDateDown() {
		return dateDown;
	}

	public void setDateDown(String dateDown) {
		this.dateDown = dateDown;
	}
	
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	private String sn;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}}