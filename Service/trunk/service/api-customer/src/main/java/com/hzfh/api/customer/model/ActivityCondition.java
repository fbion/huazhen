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


public class ActivityCondition extends BaseEntity implements Serializable {
	private int conditionType;
	public int getConditionType() {
		return conditionType;
	}
	public void setConditionType(int conditionType) {
		this.conditionType = conditionType;
	}
	private String conditionDescription;
	public String getConditionDescription() {
		return conditionDescription;
	}
	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}
	private int conditionValue;
	public int getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(int conditionValue) {
		this.conditionValue = conditionValue;
	}
	private int conditionRelation;
	public int getConditionRelation() {
		return conditionRelation;
	}
	public void setConditionRelation(int conditionRelation) {
		this.conditionRelation = conditionRelation;
	}
	private int productType;
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	private int productName;
	public int getProductName() {
		return productName;
	}
	public void setProductName(int productName) {
		this.productName = productName;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private int activityRewardType;
	public int getActivityRewardType() {
		return activityRewardType;
	}
	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	
	
}