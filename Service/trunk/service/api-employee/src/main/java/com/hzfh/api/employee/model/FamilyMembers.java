package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: huLei  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class FamilyMembers extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String familyName;
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	private String appellation;
	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	private int familyAge;
	public int getFamilyAge() {
		return familyAge;
	}
	public void setFamilyAge(int familyAge) {
		this.familyAge = familyAge;
	}
	private String familyWorkDepartment;

	public String getFamilyWorkDepartment() {
		return familyWorkDepartment;
	}

	public void setFamilyWorkDepartment(String familyWorkDepartment) {
		this.familyWorkDepartment = familyWorkDepartment;
	}

	private String familyPosition;
	public String getFamilyPosition() {
		return familyPosition;
	}
	public void setFamilyPosition(String familyPosition) {
		this.familyPosition = familyPosition;
	}
	private String familyCellphone;
	public String getFamilyCellphone() {
		return familyCellphone;
	}
	public void setFamilyCellphone(String familyCellphone) {
		this.familyCellphone = familyCellphone;
	}
}