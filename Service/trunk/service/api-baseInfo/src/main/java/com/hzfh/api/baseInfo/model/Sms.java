package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Sms extends BaseEntity implements Serializable {
	private int sysno;
	public int getSysno() {
		return sysno;
	}
	public void setSysno(int sysno) {
		this.sysno = sysno;
	}
	private String cellnumber;
	public String getCellnumber() {
		return cellnumber;
	}
	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}
	private String smscontent;
	public String getSmscontent() {
		return smscontent;
	}
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}
	private int priority;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	private int retrycount;
	public int getRetrycount() {
		return retrycount;
	}
	public void setRetrycount(int retrycount) {
		this.retrycount = retrycount;
	}
	private Timestamp handletime;
	public Timestamp getHandletime() {
		return handletime;
	}
	public void setHandletime(Timestamp handletime) {
		this.handletime = handletime;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}