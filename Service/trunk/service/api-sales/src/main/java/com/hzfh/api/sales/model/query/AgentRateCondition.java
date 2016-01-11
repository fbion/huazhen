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


public class AgentRateCondition extends QueryCondition implements Serializable {
	private int productType;
	private int product;
	private int agentType;
	private int agent;
    private String AgentAllString;
    public String getAgentAllString() {
        return AgentAllString;
    }

    public void setAgentAllString(String agentAllString) {
        AgentAllString = agentAllString;
    }

    public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
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