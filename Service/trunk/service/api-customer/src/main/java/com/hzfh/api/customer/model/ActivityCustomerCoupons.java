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


public class ActivityCustomerCoupons extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private int couponsNo;
	public int getCouponsNo() {
		return couponsNo;
	}
	public void setCouponsNo(int couponsNo) {
		this.couponsNo = couponsNo;
	}
	private Timestamp useTime;
	public Timestamp getUseTime() {
		return useTime;
	}
	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}
	private Timestamp gainTime;
	public Timestamp getGainTime() {
		return gainTime;
	}
	public void setGainTime(Timestamp gainTime) {
		this.gainTime = gainTime;
	}
	private Timestamp sendTime;
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
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
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private int cdkeyNo;
	public int getCdkeyNo() {
		return cdkeyNo;
	}
	public void setCdkeyNo(int cdkeyNo) {
		this.cdkeyNo = cdkeyNo;
	}
	private int myActivityNo;
	public int getMyActivityNo() {
		return myActivityNo;
	}
	public void setMyActivityNo(int myActivityNo) {
		this.myActivityNo = myActivityNo;
	}
	private byte couponsCdkeyStatus;
	public byte getCouponsCdkeyStatus() {
		return couponsCdkeyStatus;
	}
	public void setCouponsCdkeyStatus(byte couponsCdkeyStatus) {
		this.couponsCdkeyStatus = couponsCdkeyStatus;
	}
	
}