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


public class EvaluationScore extends BaseEntity implements Serializable {
	private int evaluationRecordNo;
	public int getEvaluationRecordNo() {
		return evaluationRecordNo;
	}
	public void setEvaluationRecordNo(int evaluationRecordNo) {
		this.evaluationRecordNo = evaluationRecordNo;
	}
	private int evaluationContentNo;
	public int getEvaluationContentNo() {
		return evaluationContentNo;
	}
	public void setEvaluationContentNo(int evaluationContentNo) {
		this.evaluationContentNo = evaluationContentNo;
	}
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	private InterviewEvaluationRecord interviewEvaluationRecord;
	public InterviewEvaluationRecord getInterviewEvaluationRecord() {
		return interviewEvaluationRecord;
	}
	public void setInterviewEvaluationRecord(
			InterviewEvaluationRecord interviewEvaluationRecord) {
		this.interviewEvaluationRecord = interviewEvaluationRecord;
	}
	
	
}