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


public class Income extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private byte customerType;
	public byte getCustomerType() {
		return customerType;
	}
	public void setCustomerType(byte customerType) {
		this.customerType = customerType;
	}
	private int customerNo;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	private int salesNo;
	public int getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	private long incomeTotal;
	public long getIncomeTotal() {
		return incomeTotal;
	}
	public void setIncomeTotal(long incomeTotal) {
		this.incomeTotal = incomeTotal;
	}
	private long incomeFirst;
	public long getIncomeFirst() {
		return incomeFirst;
	}
	public void setIncomeFirst(long incomeFirst) {
		this.incomeFirst = incomeFirst;
	}
	private long incomeReal;
	public long getIncomeReal() {
		return incomeReal;
	}
	public void setIncomeReal(long incomeReal) {
		this.incomeReal = incomeReal;
	}
	private long incomeRemain;
	public long getIncomeRemain() {
		return incomeRemain;
	}
	public void setIncomeRemain(long incomeRemain) {
		this.incomeRemain = incomeRemain;
	}
	private Timestamp receiveDate;
	public Timestamp getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Timestamp receiveDate) {
		this.receiveDate = receiveDate;
	}
	private byte partnerType;
	public byte getPartnerType() {
		return partnerType;
	}
	public void setPartnerType(byte partnerType) {
		this.partnerType = partnerType;
	}
	private int partnerNo;
	public int getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(int partnerNo) {
		this.partnerNo = partnerNo;
	}
	private byte payType;
	public byte getPayType() {
		return payType;
	}
	public void setPayType(byte payType) {
		this.payType = payType;
	}
	private String receiptNumber;
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}