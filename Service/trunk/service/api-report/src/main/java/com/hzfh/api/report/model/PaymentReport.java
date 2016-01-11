package com.hzfh.api.report.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class PaymentReport extends BaseEntity implements Serializable {
    private Date payDate;
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    private Timestamp submitTime;
    public Timestamp getSubmitTime() {
        return submitTime;
    }
    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }
    private String activitiNo;
    public String getActivitiNo() {
        return activitiNo;
    }
    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }
    private int activitiStatus;
    public int getActivitiStatus() {
        return activitiStatus;
    }
    public void setActivitiStatus(int activitiStatus) {
        this.activitiStatus = activitiStatus;
    }
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}