package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityMessage extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private int smsNo;
	public int getSmsNo() {
		return smsNo;
	}
	public void setSmsNo(int smsNo) {
		this.smsNo = smsNo;
	}
	private int emailNo;
	public int getEmailNo() {
		return emailNo;
	}
	public void setEmailNo(int emailNo) {
		this.emailNo = emailNo;
	}
	private String messageContent;
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	private String messageSubject;
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	private Timestamp messageSendTime;
	public Timestamp getMessageSendTime() {
		return messageSendTime;
	}
	public void setMessageSendTime(Timestamp messageSendTime) {
		this.messageSendTime = messageSendTime;
	}
	private byte messageType;
	public byte getMessageType() {
		return messageType;
	}
	public void setMessageType(byte messageType) {
		this.messageType = messageType;
	}
	private byte messageStatus;
	public byte getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(byte messageStatus) {
		this.messageStatus = messageStatus;
	}
}