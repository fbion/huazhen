package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class P2pInvestment extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private int p2pProductNo;
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private double income;
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	private double floatingIncome;
	public double getFloatingIncome() {
		return floatingIncome;
	}
	public void setFloatingIncome(double floatingIncome) {
		this.floatingIncome = floatingIncome;
	}
	private long totalAmout;
	public long getTotalAmout() {
		return totalAmout;
	}
	public void setTotalAmout(long totalAmout) {
		this.totalAmout = totalAmout;
	}
	private Date paymentTime;
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	private String paymentType;
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private int empNo;
	private int salesNo;
	
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	
	
	// mengchong 2015/03/22
	private String switchTotalAmout;
	public String getSwitchTotalAmout() {
		return switchTotalAmout;
	}
	public void setSwitchTotalAmout(String switchTotalAmout) {
		this.switchTotalAmout = switchTotalAmout;
	}
	private String switchStatus;
	public String getSwitchStatus() {
		return switchStatus;
	}
	public void setSwitchStatus(String switchStatus) {
		this.switchStatus = switchStatus;
	}
	
}