package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/9/8 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class Creditor extends BaseEntity implements Serializable {
    private String projectName;
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    private String roomNumber;
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    private double totalMoney;
    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    private double remainAmount;
    public double getRemainAmount() {
        return remainAmount;
    }
    public void setRemainAmount(double remainAmount) {
        this.remainAmount = remainAmount;
    }
    private int productNo;
    public int getProductNo() {return productNo;}
    public void setProductNo(int productNo) {this.productNo = productNo;}
}