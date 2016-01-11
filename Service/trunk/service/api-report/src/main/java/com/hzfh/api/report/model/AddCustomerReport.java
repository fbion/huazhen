package com.hzfh.api.report.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/20 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class AddCustomerReport extends BaseEntity implements Serializable {
    private String elementName;
    public String getElementName() {
        return elementName;
    }
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    private byte elementType;
    public byte getElementType() {
        return elementType;
    }
    public void setElementType(byte elementType) {
        this.elementType = elementType;
    }
    private int elementNo;
    public int getElementNo() {
        return elementNo;
    }
    public void setElementNo(int elementNo) {
        this.elementNo = elementNo;
    }
    private int _parentId;

    public int get_parentId() {
        return _parentId;
    }

    public void set_parentId(int _parentId) {
        this._parentId = _parentId;
    }

    private int addA;
    public int getAddA() {
        return addA;
    }
    public void setAddA(int addA) {
        this.addA = addA;
    }
    private int addB;
    public int getAddB() {
        return addB;
    }
    public void setAddB(int addB) {
        this.addB = addB;
    }
    private int addC;
    public int getAddC() {
        return addC;
    }
    public void setAddC(int addC) {
        this.addC = addC;
    }
    private int addD;
    public int getAddD() {
        return addD;
    }
    public void setAddD(int addD) {
        this.addD = addD;
    }
    private int addTotal;
    public int getAddTotal() {
        return addTotal;
    }
    public void setAddTotal(int addTotal) {
        this.addTotal = addTotal;
    }
    private int total;
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    private int empStatus;
    public int getEmpStatus() {
        return empStatus;
    }
    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }
    private int year;
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    private int month;
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    private int day;
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    private int week;
    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }
}