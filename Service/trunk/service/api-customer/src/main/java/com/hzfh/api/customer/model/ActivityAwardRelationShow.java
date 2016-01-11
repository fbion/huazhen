package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
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


public class ActivityAwardRelationShow extends BaseEntity implements Serializable {
	private int conditionId;
	public int getConditionId() {
		return conditionId;
	}
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}
	private int activityRewardType;
	public int getActivityRewardType() {
		return activityRewardType;
	}
	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	private int relatedNo;
	public int getRelatedNo() {
		return relatedNo;
	}
	public void setRelatedNo(int relatedNo) {
		this.relatedNo = relatedNo;
	}
	private String a;
	private String b;
	private String c;
	private String d;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
}