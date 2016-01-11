package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class LoginFailed extends BaseEntity implements Serializable {
	private Timestamp loginTime;
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String ip;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private String site;
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}