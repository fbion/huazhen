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


public class PaymentGatewayRequest extends BaseEntity implements Serializable {
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
	private Timestamp reqTime;
	public Timestamp getReqTime() {
		return reqTime;
	}
	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}
}