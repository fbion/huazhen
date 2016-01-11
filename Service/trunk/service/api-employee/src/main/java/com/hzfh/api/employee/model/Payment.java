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


public class Payment extends BaseEntity implements Serializable {
	private double position;
	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	private double award;
	public double getAward() {
		return award;
	}
	public void setAward(double award) {
		this.award = award;
	}
	private double allowance;
	public double getAllowance() {
		return allowance;
	}
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	private double travel;
	public double getTravel() {
		return travel;
	}
	public void setTravel(double travel) {
		this.travel = travel;
	}
	private double salary;
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private Timestamp salarydate;
	public Timestamp getSalarydate() {
		return salarydate;
	}
	public void setSalarydate(Timestamp salarydate) {
		this.salarydate = salarydate;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
}