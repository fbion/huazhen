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


public class PaymentBankCode extends BaseEntity implements Serializable {
	private String platform;
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	private int bankNo;
	public int getBankNo() {
		return bankNo;
	}
	public void setBankNo(int bankNo) {
		this.bankNo = bankNo;
	}
	private String backCode;
	public String getBackCode() {
		return backCode;
	}
	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}
	private int enable;
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}