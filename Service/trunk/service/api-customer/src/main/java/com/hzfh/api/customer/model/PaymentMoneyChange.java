package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/17 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PaymentMoneyChange extends BaseEntity implements Serializable {
	private int accountNo;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private byte accountType;
	public byte getAccountType() {
		return accountType;
	}
	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}
	private String p2pCustomerName;
	public String getP2pCustomerName() {
		return p2pCustomerName;
	}
	public void setP2pCustomerName(String p2pCustomerName) {
		this.p2pCustomerName = p2pCustomerName;
	}
	private byte moneyTransferType;
	public byte getMoneyTransferType() {
		return moneyTransferType;
	}
	public void setMoneyTransferType(byte moneyTransferType) {
		this.moneyTransferType = moneyTransferType;
	}
	private byte moneyChangeType;

	public byte getMoneyChangeType() {
		return moneyChangeType;
	}

	public void setMoneyChangeType(byte moneyChangeType) {
		this.moneyChangeType = moneyChangeType;
	}

	private double moneyAmountPre;
	public double getMoneyAmountPre() {
		return moneyAmountPre;
	}
	public void setMoneyAmountPre(double moneyAmountPre) {
		this.moneyAmountPre = moneyAmountPre;
	}
	private double moneyAmountLater;
	public double getMoneyAmountLater() {
		return moneyAmountLater;
	}
	public void setMoneyAmountLater(double moneyAmountLater) {
		this.moneyAmountLater = moneyAmountLater;
	}
	private double moneyWithdraw;
	public double getMoneyWithdraw() {
		return moneyWithdraw;
	}
	public void setMoneyWithdraw(double moneyWithdraw) {
		this.moneyWithdraw = moneyWithdraw;
	}
	private String refSn;
	public String getRefSn() {
		return refSn;
	}
	public void setRefSn(String refSn) {
		this.refSn = refSn;
	}
	private String orderNo;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	private String refBatched;
	public String getRefBatched() {
		return refBatched;
	}
	public void setRefBatched(String refBatched) {
		this.refBatched = refBatched;
	}
	private Timestamp timeCreate;
	public Timestamp getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Timestamp timeCreate) {
		this.timeCreate = timeCreate;
	}
	private String timeCreateStr;
	public String getTimeCreateStr() {
		return timeCreateStr;
	}
	public void setTimeCreateStr(String timeCreateStr) {
		this.timeCreateStr = timeCreateStr;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private Timestamp dateWork;
	public Timestamp getDateWork() {
		return dateWork;
	}
	public void setDateWork(Timestamp dateWork) {
		this.dateWork = dateWork;
	}
	
	private String p2pProductName;
	public String getP2pProductName() {
		return p2pProductName;
	}
	public void setP2pProductName(String p2pProductName) {
		this.p2pProductName = p2pProductName;
	}
	
	
}