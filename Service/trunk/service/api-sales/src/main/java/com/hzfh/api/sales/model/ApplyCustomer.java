package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ApplyCustomer extends BaseEntity implements Serializable {
	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private int customerNo;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int riskAppetite;
	public int getRiskAppetite() {
		return riskAppetite;
	}
	public void setRiskAppetite(int riskAppetite) {
		this.riskAppetite = riskAppetite;
	}
	private String tel;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	private int isSend;
	public int getIsSend() {
		return isSend;
	}
	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}
	private int isSign;
	public int getIsSign() {
		return isSign;
	}
	public void setIsSign(int isSign) {
		this.isSign = isSign;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private byte sex;
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	private String levelName;
	private String hobby;
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}