package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmailChange extends BaseEntity implements Serializable {
	private int customerNo;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	private String oldEmail;
	public String getOldEmail() {
		return oldEmail;
	}
	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}
	private String newEmali;
	public String getNewEmali() {
		return newEmali;
	}
	public void setNewEmali(String newEmali) {
		this.newEmali = newEmali;
	}
	private String portraitPath;
	public String getPortraitPath() {
		return portraitPath;
	}
	public void setPortraitPath(String portraitPath) {
		this.portraitPath = portraitPath;
	}
	private String cardPath;
	public String getCardPath() {
		return cardPath;
	}
	public void setCardPath(String cardPath) {
		this.cardPath = cardPath;
	}
	private byte pathStatus;
	public byte getPathStatus() {
		return pathStatus;
	}
	public void setPathStatus(byte pathStatus) {
		this.pathStatus = pathStatus;
	}
	private int auditor;
	public int getAuditor() {
		return auditor;
	}
	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}
	private Timestamp conftime;
	public Timestamp getConftime() {
		return conftime;
	}
	public void setConftime(Timestamp conftime) {
		this.conftime = conftime;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}