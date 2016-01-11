package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Welfare extends BaseEntity implements Serializable {
	private Timestamp sendtime;
	public Timestamp getSendtime() {
		return sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}
	private String goods;
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	private double money;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int empSendNo;
	public int getEmpSendNo() {
		return empSendNo;
	}
	public void setEmpSendNo(int empSendNo) {
		this.empSendNo = empSendNo;
	}
	private int empReceiveNo;
	public int getEmpReceiveNo() {
		return empReceiveNo;
	}
	public void setEmpReceiveNo(int empReceiveNo) {
		this.empReceiveNo = empReceiveNo;
	}
}