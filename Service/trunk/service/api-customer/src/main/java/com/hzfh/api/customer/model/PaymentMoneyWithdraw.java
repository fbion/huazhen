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


public class PaymentMoneyWithdraw extends BaseEntity implements Serializable {
	private String sn;
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	private String accountNo;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	private String customerNo;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
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
	private byte withdrawType;
	public byte getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(byte withdrawType) {
		this.withdrawType = withdrawType;
	}
	private byte bankType;
	public byte getBankType() {
		return bankType;
	}
	public void setBankType(byte bankType) {
		this.bankType = bankType;
	}
	private String bankCode;
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	private String bankAddressNo;
	public String getBankAddressNo() {
		return bankAddressNo;
	}
	public void setBankAddressNo(String bankAddressNo) {
		this.bankAddressNo = bankAddressNo;
	}
	private String bankCardNo;
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	private String bankCardName;
	public String getBankCardName() {
		return bankCardName;
	}
	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}
	private double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String resultCode;
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	private String resultNote;
	public String getResultNote() {
		return resultNote;
	}
	public void setResultNote(String resultNote) {
		this.resultNote = resultNote;
	}
	private Timestamp timeCreate;
	public Timestamp getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Timestamp timeCreate) {
		this.timeCreate = timeCreate;
	}
	private Timestamp bankTime;
	public Timestamp getBankTime() {
		return bankTime;
	}
	public void setBankTime(Timestamp bankTime) {
		this.bankTime = bankTime;
	}
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String channelNo;
	public String getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	private String monitorBatched;
	public String getMonitorBatched() {
		return monitorBatched;
	}
	public void setMonitorBatched(String monitorBatched) {
		this.monitorBatched = monitorBatched;
	}
	private String checkState;
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	private Timestamp dateWork;
	public Timestamp getDateWork() {
		return dateWork;
	}
	public void setDateWork(Timestamp dateWork) {
		this.dateWork = dateWork;
	}
	private Timestamp dateSettle;
	public Timestamp getDateSettle() {
		return dateSettle;
	}
	public void setDateSettle(Timestamp dateSettle) {
		this.dateSettle = dateSettle;
	}
	private Timestamp checkDate;
	public Timestamp getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}
	private String refSnFreeze;
	public String getRefSnFreeze() {
		return refSnFreeze;
	}
	public void setRefSnFreeze(String refSnFreeze) {
		this.refSnFreeze = refSnFreeze;
	}
	private double moneyFactorage;
	public double getMoneyFactorage() {
		return moneyFactorage;
	}
	public void setMoneyFactorage(double moneyFactorage) {
		this.moneyFactorage = moneyFactorage;
	}
	private String customerMoneyFactorage;
	
	public String getCustomerMoneyFactorage() {
		return customerMoneyFactorage;
	}
	public void setCustomerMoneyFactorage(String customerMoneyFactorage) {
		this.customerMoneyFactorage = customerMoneyFactorage;
	}
	private String factorageState;
	public String getFactorageState() {
		return factorageState;
	}
	public void setFactorageState(String factorageState) {
		this.factorageState = factorageState;
	}
}