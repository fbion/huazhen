package com.hzfh.api.report.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/11/6 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class AddSalesReport extends BaseEntity implements Serializable {
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
    private long p2pSalesMoney;

    public long getP2pSalesMoney() {
        return p2pSalesMoney;
    }

    public void setP2pSalesMoney(long p2pSalesMoney) {
        this.p2pSalesMoney = p2pSalesMoney;
    }

    private long otherSalesMoney;

    public long getOtherSalesMoney() {
        return otherSalesMoney;
    }

    public void setOtherSalesMoney(long otherSalesMoney) {
        this.otherSalesMoney = otherSalesMoney;
    }

    private long addTotalMoney;

    private long totalMoney;

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public long getAddTotalMoney() {
        return addTotalMoney;
    }

    public void setAddTotalMoney(long addTotalMoney) {
        this.addTotalMoney = addTotalMoney;
    }
    //    public int getType() {
//        return type;
//    }
//    public void setType(int type) {
//        this.type = type;
//    }
//    private int empStatus;
//    public int getEmpStatus() {
//        return empStatus;
//    }
//    public void setEmpStatus(int empStatus) {
//        this.empStatus = empStatus;
//    }
//    private int year;
//    public int getYear() {
//        return year;
//    }
//    public void setYear(int year) {
//        this.year = year;
//    }
//    private int month;
//    public int getMonth() {
//        return month;
//    }
//    public void setMonth(int month) {
//        this.month = month;
//    }
//    private int week;
//    public int getWeek() {
//        return week;
//    }
//    public void setWeek(int week) {
//        this.week = week;
//    }
//    private int day;
//    public int getDay() {
//        return day;
//    }
//    public void setDay(int day) {
//        this.day = day;
//    }
}