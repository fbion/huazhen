package com.hzfh.api.baseInfo.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/7 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class LetterCondition extends QueryCondition implements Serializable {
    private int recipient;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    private int inUserNo;
    private int status;
    private int importantDegree;
    private int eStatus;

    public int geteStatus() {
        return eStatus;
    }

    public void seteStatus(int eStatus) {
        this.eStatus = eStatus;
    }

    public int getInUserNo() {
        return inUserNo;
    }

    public void setInUserNo(int inUserNo) {
        this.inUserNo = inUserNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getImportantDegree() {
        return importantDegree;
    }

    public void setImportantDegree(int importantDegree) {
        this.importantDegree = importantDegree;
    }
}