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


public class AgentExpenseCondition extends QueryCondition implements Serializable {
	private int customerType;
	private int customer;
	private int agentType;
	private int agent;
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
	public int getAgentType() {
		return agentType;
	}
	public void setAgentType(int agentType) {
		this.agentType = agentType;
	}
	public int getAgent() {
		return agent;
	}
	public void setAgent(int agent) {
		this.agent = agent;
	}
	
	
}