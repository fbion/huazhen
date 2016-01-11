package com.hzfh.api.permission.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. Author: GuoZhenYu Create Date:
 * 2014/12/29 Description:
 * 
 * Revision History: Date Author Description
 * 
 ******************************************************************************/

public class UserRoleCondition extends QueryCondition implements Serializable {
    private int userNo;
    public int getUserNo() {
        return userNo;
    }
    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
}