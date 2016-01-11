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


public class ActivityPresent extends BaseEntity implements Serializable {
	private String presentName;
	public String getPresentName() {
		return presentName;
	}
	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}
	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private int presentCount;
	public int getPresentCount() {
		return presentCount;
	}
	public void setPresentCount(int presentCount) {
		this.presentCount = presentCount;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private double presentPrice;
	public double getPresentPrice() {
		return presentPrice;
	}
	public void setPresentPrice(double presentPrice) {
		this.presentPrice = presentPrice;
	}
	private Timestamp getPresentTime;
	public Timestamp getGetPresentTime() {
		return getPresentTime;
	}
	public void setGetPresentTime(Timestamp getPresentTime) {
		this.getPresentTime = getPresentTime;
	}
	private String conditionDescription;
	public String getConditionDescription() {
		return conditionDescription;
	}
	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}
}