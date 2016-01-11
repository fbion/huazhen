package com.hzfh.api.baseInfo.model.query;

import com.hzframework.contract.QueryCondition;

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


public class DicDataCondition extends QueryCondition implements Serializable {
    
	private int dicTypeNo;
	public int getDicTypeNo() {
        return dicTypeNo;
    }
    public void setDicTypeNo(int dicTypeNo) {
        this.dicTypeNo = dicTypeNo;
    }

    
}