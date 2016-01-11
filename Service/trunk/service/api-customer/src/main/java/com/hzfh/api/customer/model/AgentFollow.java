package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AgentFollow extends BaseEntity implements Serializable {
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
	private String contacts;
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	private String position;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	private Timestamp time;
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	private Timestamp nexttime;
	public Timestamp getNexttime() {
		return nexttime;
	}
	public void setNexttime(Timestamp nexttime) {
		this.nexttime = nexttime;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}