package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProbationEvaluationScore extends BaseEntity implements Serializable {
	private int recordNo;
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	private int contentNo;
	public int getContentNo() {
		return contentNo;
	}
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}