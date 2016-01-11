package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: huLei
 * Create Date: 2015/5/13
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


public class WorkExperience extends BaseEntity implements Serializable {
    private int empNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    private String workStartTime;

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    private String workEndTime;

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    private String workDepartment;

    public String getWorkDepartment() {
        return workDepartment;
    }

    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    private String contactPerson;

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    private String contactCellphone;

    public String getContactCellphone() {
        return contactCellphone;
    }

    public void setContactCellphone(String contactCellphone) {
        this.contactCellphone = contactCellphone;
    }

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private double monthIncome;

    public double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(double monthIncome) {
        this.monthIncome = monthIncome;
    }
}