package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

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


public class PaymentPayType extends BaseEntity implements Serializable {
	private int platformNo;
	public int getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(int platformNo) {
		this.platformNo = platformNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int isPlatform;
	public int getIsPlatform() {
		return isPlatform;
	}
	public void setIsPlatform(int isPlatform) {
		this.isPlatform = isPlatform;
	}
	private String bankCode;
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	private String payType;
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	private int enable;
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}