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


public class PaymentMoneyRecharge extends BaseEntity implements Serializable {
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
	private byte rechargeType;
	public byte getRechargeType() {
		return rechargeType;
	}
	public void setRechargeType(byte rechargeType) {
		this.rechargeType = rechargeType;
	}
	private int bankType;
	public int getBankType() {
		return bankType;
	}
	public void setBankType(int bankType) {
		this.bankType = bankType;
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
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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