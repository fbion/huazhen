package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PartnerRate extends BaseEntity implements Serializable {
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
	private byte partnerType;
	public byte getPartnerType() {
		return partnerType;
	}
	public void setPartnerType(byte partnerType) {
		this.partnerType = partnerType;
	}
	private int partnerNo;
	public int getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(int partnerNo) {
		this.partnerNo = partnerNo;
	}
	private long upperLimit;
	public long getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(long upperLimit) {
		this.upperLimit = upperLimit;
	}
	private long lowerLimit;
	public long getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(long lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	private double rate;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	private double rateAdd;
	public double getRateAdd() {
		return rateAdd;
	}
	public void setRateAdd(double rateAdd) {
		this.rateAdd = rateAdd;
	}
}