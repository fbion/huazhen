package com.hzfh.api.log.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/25 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class ProductLog extends BaseEntity implements Serializable {
    private int productNo;
    public int getProductNo() {
        return productNo;
    }
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private String action;
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    private String method;
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    private String afterData;
    public String getAfterData() {
        return afterData;
    }
    public void setAfterData(String afterData) {
        this.afterData = afterData;
    }
    private String exception;
    public String getException() {
        return exception;
    }
    public void setException(String exception) {
        this.exception = exception;
    }
}