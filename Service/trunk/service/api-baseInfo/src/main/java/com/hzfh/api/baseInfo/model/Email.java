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


public class Email extends BaseEntity implements Serializable {
	private String to;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	private String cc;
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	private String subject;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	private String host;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String suffix;
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	private String senderName;
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	private String body;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private Timestamp sendtime;
	public Timestamp getSendtime() {
		return sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}
	private String fromName;
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	
}