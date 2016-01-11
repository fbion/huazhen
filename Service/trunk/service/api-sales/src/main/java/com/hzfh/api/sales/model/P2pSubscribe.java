package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class P2pSubscribe extends BaseEntity implements Serializable {
	private int p2pCustomer;
	
	public int getP2pCustomer() {
		return p2pCustomer;
	}
	public void setP2pCustomer(int p2pCustomer) {
		this.p2pCustomer = p2pCustomer;
	}
	private String realName;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	private String cellphone;
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	private int provinceNo;
	public int getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}
	private int cityNo;
	public int getCityNo() {
		return cityNo;
	}
	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}
	private int districtNo;
	public int getDistrictNo() {
		return districtNo;
	}
	public void setDistrictNo(int districtNo) {
		this.districtNo = districtNo;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private byte cardType;
	public byte getCardType() {
		return cardType;
	}
	public void setCardType(byte cardType) {
		this.cardType = cardType;
	}
	private String cardNumber;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	private long amount;
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private Date visitTime;
	
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private int p2pProductNo;
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	private int customerNo;

	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	
	
	//p2p产品名称
	private String p2pProductName;

	public String getP2pProductName() {
		return p2pProductName;
	}
	public void setP2pProductName(String p2pProductName) {
		this.p2pProductName = p2pProductName;
	}
	//理财顾问姓名
	private String empName;

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//预约金额转换
	private String switchAmount;

	public String getSwitchAmount() {
		return switchAmount;
	}
	public void setSwitchAmount(String switchAmount) {
		this.switchAmount = switchAmount;
	}
	
	
	private String empCellphone;

	public String getEmpCellphone() {
		return empCellphone;
	}
	public void setEmpCellphone(String empCellphone) {
		this.empCellphone = empCellphone;
	}
	

	
	
}