package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/30 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class CommissionWealthCenterCondition extends QueryCondition implements Serializable {
    private String empName;
    private int deptNo;
    private int positionNo;
    private int year;
    private int month;

    public String getEmpName() {

        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public int getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(int positionNo) {
        this.positionNo = positionNo;
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
}