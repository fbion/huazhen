package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/15 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class SalesEmpCalculate extends BaseEntity implements Serializable {
	private String salesCode;
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	private Timestamp dealTime;
	public Timestamp getDealTime() {
		return dealTime;
	}
	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}
	private double moneySale;
	public double getMoneySale() {
		return moneySale;
	}
	public void setMoneySale(double moneySale) {
		this.moneySale = moneySale;
	}
	private double moneyContribute;
	public double getMoneyContribute() {
		return moneyContribute;
	}
	public void setMoneyContribute(double moneyContribute) {
		this.moneyContribute = moneyContribute;
	}
	private Timestamp calcTime;
	public Timestamp getCalcTime() {
		return calcTime;
	}
	public void setCalcTime(Timestamp calcTime) {
		this.calcTime = calcTime;
	}
}