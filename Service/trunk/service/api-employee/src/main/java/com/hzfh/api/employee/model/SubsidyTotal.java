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


public class SubsidyTotal extends BaseEntity implements Serializable {
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private float subsidyScale;
	public float getSubsidyScale() {
		return subsidyScale;
	}
	public void setSubsidyScale(float subsidyScale) {
		this.subsidyScale = subsidyScale;
	}
	private float salesMoney;
	
	public float getSalesMoney() {
		return salesMoney;
	}
	public void setSalesMoney(float salesMoney) {
		this.salesMoney = salesMoney;
	}
	private float subsidy;
	
	public float getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(float subsidy) {
		this.subsidy = subsidy;
	}
	private Date achieveTime;
	public Date getAchieveTime() {
		return achieveTime;
	}
	public void setAchieveTime(Date achieveTime) {
		this.achieveTime = achieveTime;
	}
	private int isExamine;
	public int getIsExamine() {
		return isExamine;
	}
	public void setIsExamine(int isExamine) {
		this.isExamine = isExamine;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
}