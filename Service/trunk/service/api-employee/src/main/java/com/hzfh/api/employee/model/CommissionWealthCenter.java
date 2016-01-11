package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

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


public class CommissionWealthCenter extends BaseEntity implements Serializable {
    private int empNo;
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    private String empName;
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
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
    private int salesMoney;
    public int getSalesMoney() {
        return salesMoney;
    }
    public void setSalesMoney(int salesMoney) {
        this.salesMoney = salesMoney;
    }
    private float commissionScale;
    public float getCommissionScale() {
        return commissionScale;
    }
    public void setCommissionScale(float commissionScale) {
        this.commissionScale = commissionScale;
    }
    private int establishMoney;
    public int getEstablishMoney() {
        return establishMoney;
    }
    public void setEstablishMoney(int establishMoney) {
        this.establishMoney = establishMoney;
    }
    private int commissionMoney;
    public int getCommissionMoney() {
        return commissionMoney;
    }
    public void setCommissionMoney(int commissionMoney) {
        this.commissionMoney = commissionMoney;
    }
    private int isExamine;
    public int getIsExamine() {
        return isExamine;
    }
    public void setIsExamine(int isExamine) {
        this.isExamine = isExamine;
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
    private int productNo;
    private String type;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}