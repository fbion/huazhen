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


public class ProbationEvaluationContentTemplate extends BaseEntity implements Serializable {
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}