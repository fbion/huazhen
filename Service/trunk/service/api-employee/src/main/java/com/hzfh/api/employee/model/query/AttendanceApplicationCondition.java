package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AttendanceApplicationCondition extends QueryCondition implements Serializable {
    private int byName;
    private int byDept;
    private int byType;
    private int byYear;
    private int byMonth;
    private int byStatus;

    public int getByStatus() {
        return byStatus;
    }

    public void setByStatus(int byStatus) {
        this.byStatus = byStatus;
    }

    public int getByName() {
        return byName;
    }

    public void setByName(int byName) {
        this.byName = byName;
    }

    public int getByDept() {
        return byDept;
    }

    public void setByDept(int byDept) {
        this.byDept = byDept;
    }

    public int getByType() {
        return byType;
    }

    public void setByType(int byType) {
        this.byType = byType;
    }

    public int getByYear() {
        return byYear;
    }

    public void setByYear(int byYear) {
        this.byYear = byYear;
    }

    public int getByMonth() {
        return byMonth;
    }

    public void setByMonth(int byMonth) {
        this.byMonth = byMonth;
    }
    private String workMateString;

    public String getWorkMateString() {
        return workMateString;
    }

    public void setWorkMateString(String workMateString) {
        this.workMateString = workMateString;
    }
}