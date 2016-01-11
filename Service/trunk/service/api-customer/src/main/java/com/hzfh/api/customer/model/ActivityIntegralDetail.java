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


public class ActivityIntegralDetail extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private byte changeType;
	public byte getChangeType() {
		return changeType;
	}
	public void setChangeType(byte changeType) {
		this.changeType = changeType;
	}
	private int changeIntegral;
	public int getChangeIntegral() {
		return changeIntegral;
	}
	public void setChangeIntegral(int changeIntegral) {
		this.changeIntegral = changeIntegral;
	}
	private int changeIntegralAvailable;
	public int getChangeIntegralAvailable() {
		return changeIntegralAvailable;
	}
	public void setChangeIntegralAvailable(int changeIntegralAvailable) {
		this.changeIntegralAvailable = changeIntegralAvailable;
	}
	private Timestamp startTime;
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	private Timestamp endTime;
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	private byte integralSatus;
	public byte getIntegralSatus() {
		return integralSatus;
	}
	public void setIntegralSatus(byte integralSatus) {
		this.integralSatus = integralSatus;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int relatedNo;
	public int getRelatedNo() {
		return relatedNo;
	}
	public void setRelatedNo(int relatedNo) {
		this.relatedNo = relatedNo;
	}
	private int integraNo;
	public int getIntegraNo() {
		return integraNo;
	}
	public void setIntegraNo(int integraNo) {
		this.integraNo = integraNo;
	}
	private Timestamp gainTime;
	public Timestamp getGainTime() {
		return gainTime;
	}
	public void setGainTime(Timestamp gainTime) {
		this.gainTime = gainTime;
	}
	private int myActivityNo;
	public int getMyActivityNo() {
		return myActivityNo;
	}
	public void setMyActivityNo(int myActivityNo) {
		this.myActivityNo = myActivityNo;
	}
}