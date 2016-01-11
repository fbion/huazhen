package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/3/5
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public class P2pProduct extends BaseEntity implements Serializable {
    private byte repaymentIssue;

    public byte getRepaymentIssue() {
        return repaymentIssue;
    }

    public void setRepaymentIssue(byte repaymentIssue) {
        this.repaymentIssue = repaymentIssue;
    }

    private int borrowerUserNo;

    public int getBorrowerUserNo() {
        return borrowerUserNo;
    }

    public void setBorrowerUserNo(int borrowerUserNo) {
        this.borrowerUserNo = borrowerUserNo;
    }

    private String borrowerUserName;

    public String getBorrowerUserName() {
        return borrowerUserName;
    }

    public void setBorrowerUserName(String borrowerUserName) {
        this.borrowerUserName = borrowerUserName;
    }

    private String contract;

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    private int productNo;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private double income;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    private double floatingIncome;

    public double getFloatingIncome() {
        return floatingIncome;
    }

    public void setFloatingIncome(double floatingIncome) {
        this.floatingIncome = floatingIncome;
    }

    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private long totalAmout;

    public long getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(long totalAmout) {
        this.totalAmout = totalAmout;
    }

    private double progress;

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    private long remainAmout;

    public long getRemainAmout() {
        return remainAmout;
    }

    public void setRemainAmout(long remainAmout) {
        this.remainAmout = remainAmout;
    }

    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    private int orderCount;

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    private byte status;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    private Date start;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    private Date end;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    private byte isTest;

    public byte getIsTest() {
        return isTest;
    }

    public void setIsTest(byte isTest) {
        this.isTest = isTest;
    }

    private int level;//优先级

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String productAdvantage;//产品优势

    public String getProductAdvantage() {
        return productAdvantage;
    }

    public void setProductAdvantage(String productAdvantage) {
        this.productAdvantage = productAdvantage;
    }

    private int minMoney;

    public int getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(int minMoney) {
        this.minMoney = minMoney;
    }

    private String switchTotalAmout;
    private String switchRemainAmout;

    public String getSwitchTotalAmout() {
        return switchTotalAmout;
    }

    public void setSwitchTotalAmout(String switchTotalAmout) {
        this.switchTotalAmout = switchTotalAmout;
    }

    public String getSwitchRemainAmout() {
        return switchRemainAmout;
    }

    public void setSwitchRemainAmout(String switchRemainAmout) {
        this.switchRemainAmout = switchRemainAmout;
    }

    private int rowIndex;

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    private byte investQuitStatus;
    private byte supportCoupon;
    private String logoPath;

    public byte getInvestQuitStatus() {
        return investQuitStatus;
    }

    public void setInvestQuitStatus(byte investQuitStatus) {
        this.investQuitStatus = investQuitStatus;
    }

    public byte getSupportCoupon() {
        return supportCoupon;
    }

    public void setSupportCoupon(byte supportCoupon) {
        this.supportCoupon = supportCoupon;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    private byte type;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String activitiNo;

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }
}