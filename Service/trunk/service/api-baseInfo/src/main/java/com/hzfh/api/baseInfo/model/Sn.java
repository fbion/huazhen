package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Sn extends BaseEntity implements Serializable {
	private String timeCode;
	public String getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}
	private String bizCode;
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}