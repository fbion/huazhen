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


public class ActivityFeedback extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private String advise;
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	private Timestamp feedbackTime;
	public Timestamp getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(Timestamp feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int approverNo;
	public int getApproverNo() {
		return approverNo;
	}
	public void setApproverNo(int approverNo) {
		this.approverNo = approverNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}