package com.hzfh.api.report.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class DeptSalesTotal extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private String deptName;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	private double moneyTotal;
	public double getMoneyTotal() {
		return moneyTotal;
	}
	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}
	
	private int count;
	private int deptType;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDeptType() {
		return deptType;
	}
	public void setDeptType(int deptType) {
		this.deptType = deptType;
	}
	
	
	
}