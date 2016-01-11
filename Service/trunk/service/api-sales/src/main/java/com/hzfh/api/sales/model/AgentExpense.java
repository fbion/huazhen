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


public class AgentExpense extends BaseEntity implements Serializable {
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
	private long payTotal;
	public long getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(long payTotal) {
		this.payTotal = payTotal;
	}
	private long payFirst;
	public long getPayFirst() {
		return payFirst;
	}
	public void setPayFirst(long payFirst) {
		this.payFirst = payFirst;
	}
	private long payReal;
	public long getPayReal() {
		return payReal;
	}
	public void setPayReal(long payReal) {
		this.payReal = payReal;
	}
	private long payRemain;
	public long getPayRemain() {
		return payRemain;
	}
	public void setPayRemain(long payRemain) {
		this.payRemain = payRemain;
	}
	private Timestamp payDate;
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	private byte agentType;
	public byte getAgentType() {
		return agentType;
	}
	public void setAgentType(byte agentType) {
		this.agentType = agentType;
	}
	private int agentNo;
	public int getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(int agentNo) {
		this.agentNo = agentNo;
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