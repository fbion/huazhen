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


public class ActivityCoupons extends BaseEntity implements Serializable {
	private int couponsValue;
	public int getCouponsValue() {
		return couponsValue;
	}
	public void setCouponsValue(int couponsValue) {
		this.couponsValue = couponsValue;
	}
	private byte couponsGetWay;
	public byte getCouponsGetWay() {
		return couponsGetWay;
	}
	public void setCouponsGetWay(byte couponsGetWay) {
		this.couponsGetWay = couponsGetWay;
	}
	private byte couponsMode;
	public byte getCouponsMode() {
		return couponsMode;
	}
	public void setCouponsMode(byte couponsMode) {
		this.couponsMode = couponsMode;
	}
	private String couponsRule;
	public String getCouponsRule() {
		return couponsRule;
	}
	public void setCouponsRule(String couponsRule) {
		this.couponsRule = couponsRule;
	}
	private int couponsIntegralCount;
	public int getCouponsIntegralCount() {
		return couponsIntegralCount;
	}
	public void setCouponsIntegralCount(int couponsIntegralCount) {
		this.couponsIntegralCount = couponsIntegralCount;
	}
	private int couponsTotal;
	public int getCouponsTotal() {
		return couponsTotal;
	}
	public void setCouponsTotal(int couponsTotal) {
		this.couponsTotal = couponsTotal;
	}
	private Timestamp couponsStartTime;
	public Timestamp getCouponsStartTime() {
		return couponsStartTime;
	}
	public void setCouponsStartTime(Timestamp couponsStartTime) {
		this.couponsStartTime = couponsStartTime;
	}
	private Timestamp couponsEndTime;
	public Timestamp getCouponsEndTime() {
		return couponsEndTime;
	}
	public void setCouponsEndTime(Timestamp couponsEndTime) {
		this.couponsEndTime = couponsEndTime;
	}
	private int couponsSurplus;
	public int getCouponsSurplus() {
		return couponsSurplus;
	}
	public void setCouponsSurplus(int couponsSurplus) {
		this.couponsSurplus = couponsSurplus;
	}
	private String couponsComment;
	public String getCouponsComment() {
		return couponsComment;
	}
	public void setCouponsComment(String couponsComment) {
		this.couponsComment = couponsComment;
	}
	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private String conditionDescription;
	public String getConditionDescription() {
		return conditionDescription;
	}
	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}
}