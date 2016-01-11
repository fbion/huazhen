package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Subsidy extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private float money;
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	private int source;
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	private Date sendTime;
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	private int isSend;
	public int getIsSend() {
		return isSend;
	}
	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}
	
	private Date sourceDate;
	public Date getSourceDate() {
		return sourceDate;
	}
	public void setSourceDate(Date sourceDate) {
		this.sourceDate = sourceDate;
	}
	
	
}