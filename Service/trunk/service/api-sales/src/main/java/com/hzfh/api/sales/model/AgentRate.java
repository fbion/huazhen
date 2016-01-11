package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/15 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AgentRate extends BaseEntity implements Serializable {
	private byte productType;
	public byte getProductType() {
		return productType;
	}
	public void setProductType(byte productType) {
		this.productType = productType;
	}
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private byte agentType;
	public byte getAgentType() {
		return agentType;
	}
	public void setAgentType(byte agentType) {
		this.agentType = agentType;
	}
	private int agentNo;
	public int getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(int agentNo) {
		this.agentNo = agentNo;
	}
	private long lowerLimit;
	public long getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(long lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	private long upperLimit;
	public long getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(long upperLimit) {
		this.upperLimit = upperLimit;
	}
	private double rate;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}