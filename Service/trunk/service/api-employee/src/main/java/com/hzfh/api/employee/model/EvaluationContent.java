package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EvaluationContent extends BaseEntity implements Serializable {
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	private String item;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	private int parentNo;
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	private double grade;
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	private String point;
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	private String standard;
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	private String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}