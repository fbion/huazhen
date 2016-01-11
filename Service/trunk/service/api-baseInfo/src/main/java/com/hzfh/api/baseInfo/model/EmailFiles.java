package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmailFiles extends BaseEntity implements Serializable {
	private int emailNo;
	public int getEmailNo() {
		return emailNo;
	}
	public void setEmailNo(int emailNo) {
		this.emailNo = emailNo;
	}
	private String fileUrl;
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}