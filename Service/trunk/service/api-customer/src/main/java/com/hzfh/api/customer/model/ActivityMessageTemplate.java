package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityMessageTemplate extends BaseEntity implements Serializable {
	private String subjectTemplate;
	public String getSubjectTemplate() {
		return subjectTemplate;
	}
	public void setSubjectTemplate(String subjectTemplate) {
		this.subjectTemplate = subjectTemplate;
	}
	private String contentTemplate;
	public String getContentTemplate() {
		return contentTemplate;
	}
	public void setContentTemplate(String contentTemplate) {
		this.contentTemplate = contentTemplate;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private byte satus;
	public byte getSatus() {
		return satus;
	}
	public void setSatus(byte satus) {
		this.satus = satus;
	}
}