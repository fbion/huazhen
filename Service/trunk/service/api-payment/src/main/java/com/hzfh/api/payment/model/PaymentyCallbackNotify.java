package com.hzfh.api.payment.model;


import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PaymentyCallbackNotify extends BaseEntity implements Serializable {
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String param;
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	private String sign;
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	private String operType;
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Timestamp respTime;
	public Timestamp getRespTime() {
		return respTime;
	}
	public void setRespTime(Timestamp respTime) {
		this.respTime = respTime;
	}
}