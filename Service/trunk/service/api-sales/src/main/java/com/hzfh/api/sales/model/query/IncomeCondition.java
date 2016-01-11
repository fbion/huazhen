package com.hzfh.api.sales.model.query;


import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class IncomeCondition extends QueryCondition implements Serializable {
	private String name;
	private int customerType;
	private int customer;
	private int partner;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	
	
	
}