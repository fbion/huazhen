package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/12 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class EmpCompilePlan extends BaseEntity implements Serializable {
    private int companyNo;
    public int getCompanyNo() {
        return companyNo;
    }
    public void setCompanyNo(int companyNo) {
        this.companyNo = companyNo;
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
    private int dueEmpNumber;
    public int getDueEmpNumber() {
        return dueEmpNumber;
    }
    public void setDueEmpNumber(int dueEmpNumber) {
        this.dueEmpNumber = dueEmpNumber;
    }
    private int realEmpNumber;
    public int getRealEmpNumber() {
        return realEmpNumber;
    }
    public void setRealEmpNumber(int realEmpNumber) {
        this.realEmpNumber = realEmpNumber;
    }
    private String allEmpName;
    public String getAllEmpName() {
        return allEmpName;
    }
    public void setAllEmpName(String allEmpName) {
        this.allEmpName = allEmpName;
    }
    private int lackEmpNumber;
    public int getLackEmpNumber() {
        return lackEmpNumber;
    }
    public void setLackEmpNumber(int lackEmpNumber) {
        this.lackEmpNumber = lackEmpNumber;
    }
    private Date planTime;
    public Date getPlanTime() {
        return planTime;
    }
    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
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