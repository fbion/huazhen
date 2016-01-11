package com.hzfh.api.report.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/15 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class AddCustomerReportCondition extends QueryCondition implements Serializable {
    private int year;
    private int month;
    private int day;
    private int week;
    private int type;
    private String depts;
    private int empStatus;

    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    public String getDepts() {
        return depts;
    }

    public void setDepts(String depts) {
        this.depts = depts;
    }

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}