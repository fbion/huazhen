package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmpBrokerageLadder extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private long upperLimit;
	public long getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(long upperLimit) {
		this.upperLimit = upperLimit;
	}
	private long lowerLimit;
	public long getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(long lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	private double moneyAdd;
	public double getMoneyAdd() {
		return moneyAdd;
	}
	public void setMoneyAdd(double moneyAdd) {
		this.moneyAdd = moneyAdd;
	}
	private double rate;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}