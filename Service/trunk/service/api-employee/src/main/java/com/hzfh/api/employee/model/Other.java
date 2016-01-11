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


public class Other extends BaseEntity implements Serializable {
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
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
	private int days;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private byte leavetypeNo;
	public byte getLeavetypeNo() {
		return leavetypeNo;
	}
	public void setLeavetypeNo(byte leavetypeNo) {
		this.leavetypeNo = leavetypeNo;
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