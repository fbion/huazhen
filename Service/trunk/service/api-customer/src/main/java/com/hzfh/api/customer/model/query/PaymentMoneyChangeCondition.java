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


public class PaymentMoneyChangeCondition extends QueryCondition implements Serializable {

	private int customerNo;
	private int moneyChangeType;
	private String startTime;
	private String endTime;
	
	

	public int getMoneyChangeType() {
		return moneyChangeType;
	}

	public void setMoneyChangeType(int moneyChangeType) {
		this.moneyChangeType = moneyChangeType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	
	
	
	
	
}