package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

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


public class InterviewEvaluationRecord extends BaseEntity implements Serializable {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private byte sex;
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	private int desirePositionNo;
	public int getDesirePositionNo() {
		return desirePositionNo;
	}
	public void setDesirePositionNo(int desirePositionNo) {
		this.desirePositionNo = desirePositionNo;
	}
	private Date firstTime;
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	private double totalScore;
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	private String evaluation;
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	private byte conclusion;
	public byte getConclusion() {
		return conclusion;
	}
	public void setConclusion(byte conclusion) {
		this.conclusion = conclusion;
	}
	private int hirePositionNo;
	public int getHirePositionNo() {
		return hirePositionNo;
	}
	public void setHirePositionNo(int hirePositionNo) {
		this.hirePositionNo = hirePositionNo;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private Date interviewDate;
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	private String firstEvaluation;
	public String getFirstEvaluation() {
		return firstEvaluation;
	}
	public void setFirstEvaluation(String firstEvaluation) {
		this.firstEvaluation = firstEvaluation;
	}
	private String secondEvaluation;
	public String getSecondEvaluation() {
		return secondEvaluation;
	}
	public void setSecondEvaluation(String secondEvaluation) {
		this.secondEvaluation = secondEvaluation;
	}
	private int retestUserNo;

    public int getRetestUserNo() {
        return retestUserNo;
    }

    public void setRetestUserNo(int retestUserNo) {
        this.retestUserNo = retestUserNo;
    }
    /*//一对多
	private List<EvaluationScore> evaluationScoreList;
	public List<EvaluationScore> getEvaluationScoreList() {
		return evaluationScoreList;
	}
	public void setEvaluationScoreList(List<EvaluationScore> evaluationScoreList) {
		this.evaluationScoreList = evaluationScoreList;
	}*/
	
}