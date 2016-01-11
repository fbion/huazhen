package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/9/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class RecruitFollow extends BaseEntity implements Serializable {
	private int recruitId;
	public int getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(int recruitId) {
		this.recruitId = recruitId;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}