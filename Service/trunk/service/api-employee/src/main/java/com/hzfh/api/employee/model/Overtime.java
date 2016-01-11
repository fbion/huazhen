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


public class Overtime extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private Timestamp apply;
	public Timestamp getApply() {
		return apply;
	}
	public void setApply(Timestamp apply) {
		this.apply = apply;
	}
	private Timestamp begin;
	public Timestamp getBegin() {
		return begin;
	}
	public void setBegin(Timestamp begin) {
		this.begin = begin;
	}
	private Timestamp end;
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private int checkEmpNo;
	public int getCheckEmpNo() {
		return checkEmpNo;
	}
	public void setCheckEmpNo(int checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}
	private byte checkOk;
	public byte getCheckOk() {
		return checkOk;
	}
	public void setCheckOk(byte checkOk) {
		this.checkOk = checkOk;
	}
}