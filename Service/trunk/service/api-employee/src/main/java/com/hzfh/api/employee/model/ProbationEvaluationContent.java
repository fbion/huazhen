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


public class ProbationEvaluationContent extends BaseEntity implements Serializable {
	private int recordNo;
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private byte scale;
	public byte getScale() {
		return scale;
	}
	public void setScale(byte scale) {
		this.scale = scale;
	}
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}