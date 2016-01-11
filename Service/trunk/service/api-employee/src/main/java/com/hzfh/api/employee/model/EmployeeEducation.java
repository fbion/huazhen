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


public class EmployeeEducation extends BaseEntity implements Serializable {
    private int empNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    private byte education;

    public byte getEducation() {
        return education;
    }

    public void setEducation(byte education) {
        this.education = education;
    }

    private byte degree;

    public byte getDegree() {
        return degree;
    }

    public void setDegree(byte degree) {
        this.degree = degree;
    }

    private String graduationSchool;

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String admissionTime;

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    private String graduationTime;

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

}