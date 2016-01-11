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


public class BrokerageCalculate extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private double moneyTotal;
	public double getMoneyTotal() {
		return moneyTotal;
	}
	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}
	private int sumOrder;
	public int getSumOrder() {
		return sumOrder;
	}
	public void setSumOrder(int sumOrder) {
		this.sumOrder = sumOrder;
	}
	private double moneyBrokerage;
	public double getMoneyBrokerage() {
		return moneyBrokerage;
	}
	public void setMoneyBrokerage(double moneyBrokerage) {
		this.moneyBrokerage = moneyBrokerage;
	}
	private Timestamp calcTime;
	public Timestamp getCalcTime() {
		return calcTime;
	}
	public void setCalcTime(Timestamp calcTime) {
		this.calcTime = calcTime;
	}
}