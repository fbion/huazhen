package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PaymentAccountInformation extends BaseEntity implements Serializable {
	private int customerNo;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	private byte accountType;
	public byte getAccountType() {
		return accountType;
	}
	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private double moneyAmount;
	public double getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	private double moneyWithdraw;
	public double getMoneyWithdraw() {
		return moneyWithdraw;
	}
	public void setMoneyWithdraw(double moneyWithdraw) {
		this.moneyWithdraw = moneyWithdraw;
	}
	private double moneyFreeze;
	public double getMoneyFreeze() {
		return moneyFreeze;
	}
	public void setMoneyFreeze(double moneyFreeze) {
		this.moneyFreeze = moneyFreeze;
	}
	private byte property;
	public byte getProperty() {
		return property;
	}
	public void setProperty(byte property) {
		this.property = property;
	}
	private byte state;
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	private int platformNo;
	public int getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(int platformNo) {
		this.platformNo = platformNo;
	}
	private String platformCardNo;
	public String getPlatformCardNo() {
		return platformCardNo;
	}
	public void setPlatformCardNo(String platformCardNo) {
		this.platformCardNo = platformCardNo;
	}
	private Timestamp timeCreate;
	public Timestamp getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Timestamp timeCreate) {
		this.timeCreate = timeCreate;
	}
	private double earnings;
	public double getEarnings() {
		return earnings;
	}
	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
	private double earningsRecently;
	public double getEarningsRecently() {
		return earningsRecently;
	}
	public void setEarningsRecently(double earningsRecently) {
		this.earningsRecently = earningsRecently;
	}
	private int integralAmount;
	public int getIntegralAmount() {
		return integralAmount;
	}
	public void setIntegralAmount(int integralAmount) {
		this.integralAmount = integralAmount;
	}
	private int integralWithdraw;
	public int getIntegralWithdraw() {
		return integralWithdraw;
	}
	public void setIntegralWithdraw(int integralWithdraw) {
		this.integralWithdraw = integralWithdraw;
	}
	private double accrualBase;
	public double getAccrualBase() {
		return accrualBase;
	}
	public void setAccrualBase(double accrualBase) {
		this.accrualBase = accrualBase;
	}
	private Timestamp accrualTimePeriod;
	public Timestamp getAccrualTimePeriod() {
		return accrualTimePeriod;
	}
	public void setAccrualTimePeriod(Timestamp accrualTimePeriod) {
		this.accrualTimePeriod = accrualTimePeriod;
	}
	private double moneyAmountPeriod;
	public double getMoneyAmountPeriod() {
		return moneyAmountPeriod;
	}
	public void setMoneyAmountPeriod(double moneyAmountPeriod) {
		this.moneyAmountPeriod = moneyAmountPeriod;
	}
	private String checkValue;
	public String getCheckValue() {
		return checkValue;
	}
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	private int authenticationName;
	public int getAuthenticationName() {
		return authenticationName;
	}
	public void setAuthenticationName(int authenticationName) {
		this.authenticationName = authenticationName;
	}
	private int authenticationIdcard;
	public int getAuthenticationIdcard() {
		return authenticationIdcard;
	}
	public void setAuthenticationIdcard(int authenticationIdcard) {
		this.authenticationIdcard = authenticationIdcard;
	}
	private int authenticationBankCard;
	public int getAuthenticationBankCard() {
		return authenticationBankCard;
	}
	public void setAuthenticationBankCard(int authenticationBankCard) {
		this.authenticationBankCard = authenticationBankCard;
	}
	private int authenticationTel;
	public int getAuthenticationTel() {
		return authenticationTel;
	}
	public void setAuthenticationTel(int authenticationTel) {
		this.authenticationTel = authenticationTel;
	}
	private int authenticationEmail;
	public int getAuthenticationEmail() {
		return authenticationEmail;
	}
	public void setAuthenticationEmail(int authenticationEmail) {
		this.authenticationEmail = authenticationEmail;
	}
	private int accountPwd;
	public int getAccountPwd() {
		return accountPwd;
	}
	public void setAccountPwd(int accountPwd) {
		this.accountPwd = accountPwd;
	}
	
	private String sn;
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
}