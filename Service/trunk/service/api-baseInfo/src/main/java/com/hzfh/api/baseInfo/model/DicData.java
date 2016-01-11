package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class DicData extends BaseEntity implements Serializable {
    private byte code;
    public byte getCode() {
        return code;
    }
    public void setCode(byte code) {
        this.code = code;
    }
    private int dicTypeNo;
    public int getDicTypeNo() {
        return dicTypeNo;
    }
    public void setDicTypeNo(int dicTypeNo) {
        this.dicTypeNo = dicTypeNo;
    }
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}