package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/3 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class SmsCaptcha extends BaseEntity implements Serializable {
    private String code;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    private Timestamp expireTime;
    public Timestamp getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }
    private int status;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    private int userNo;
    public int getUserNo() {
        return userNo;
    }
    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
    private String telephone;
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}