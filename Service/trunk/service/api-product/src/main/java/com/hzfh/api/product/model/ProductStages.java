package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProductStages extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private int stage;
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	private Timestamp start;
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	private Timestamp end;
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	private int dayCount;
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	private long amount;
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private long sumMoney;
	public long getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(long sumMoney) {
		this.sumMoney = sumMoney;
	}
	
}