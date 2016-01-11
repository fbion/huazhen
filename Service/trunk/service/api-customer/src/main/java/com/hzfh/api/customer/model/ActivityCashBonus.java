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


public class ActivityCashBonus extends BaseEntity implements Serializable {
	private double money;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private int isTake;
	public int getIsTake() {
		return isTake;
	}
	public void setIsTake(int isTake) {
		this.isTake = isTake;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
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
	private String conditionDescription;
	public String getConditionDescription() {
		return conditionDescription;
	}
	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}
}