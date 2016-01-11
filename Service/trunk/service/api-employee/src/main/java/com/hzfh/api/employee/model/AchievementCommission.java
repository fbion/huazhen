package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;


/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AchievementCommission extends BaseEntity implements Serializable {
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
	private int standard;
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	private int salesMoney;
	public int getSalesMoney() {
		return salesMoney;
	}
	public void setSalesMoney(int salesMoney) {
		this.salesMoney = salesMoney;
	}
	private int finishScale;
	public int getFinishScale() {
		return finishScale;
	}
	public void setFinishScale(int finishScale) {
		this.finishScale = finishScale;
	}
	private float commissionScale;
	public float getCommissionScale() {
		return commissionScale;
	}
	public void setCommissionScale(float commissionScale) {
		this.commissionScale = commissionScale;
	}
	private double  commissionMoney;

    public double getCommissionMoney() {
        return commissionMoney;
    }

    public void setCommissionMoney(double  commissionMoney) {
        this.commissionMoney = commissionMoney;
    }

    private int isExamine;
	public int getIsExamine() {
		return isExamine;
	}
	public void setIsExamine(int isExamine) {
		this.isExamine = isExamine;
	}
	
	private int deptNo;
	private int positionNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	
	private int year;
	private int month;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	
}