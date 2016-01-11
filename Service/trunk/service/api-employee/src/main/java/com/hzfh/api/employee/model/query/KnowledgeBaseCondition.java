package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class KnowledgeBaseCondition extends QueryCondition implements Serializable {
//	private byte byType;
//	private String key;
//	public byte getByType() {
//		return byType;
//	}
//	public void setByType(byte byType) {
//		this.byType = byType;
//	}
//	public String getKey() {
//		return key;
//	}
//	public void setKey(String key) {
//		this.key = key;
//	}

    private String byTitle;
    private int byType;

    public String getByTitle() {
        return byTitle;
    }

    public void setByTitle(String byTitle) {
        this.byTitle = byTitle;
    }

    public int getByType() {
        return byType;
    }

    public void setByType(int byType) {
        this.byType = byType;
    }
}