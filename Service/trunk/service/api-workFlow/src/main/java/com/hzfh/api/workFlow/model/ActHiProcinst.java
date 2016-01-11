package com.hzfh.api.workFlow.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActHiProcinst extends BaseEntity implements Serializable {
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	private String procInstId;
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	private String businessKey;
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	private String procDefId;
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	private Timestamp startTime;
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	private Timestamp endTime;
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	private long duration;
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	private String startUserId;
	public String getStartUserId() {
		return startUserId;
	}
	public void setStartUserId(String startUserId) {
		this.startUserId = startUserId;
	}
	private String startActId;
	public String getStartActId() {
		return startActId;
	}
	public void setStartActId(String startActId) {
		this.startActId = startActId;
	}
	private String endActId;
	public String getEndActId() {
		return endActId;
	}
	public void setEndActId(String endActId) {
		this.endActId = endActId;
	}
	private String superProcessInstanceId;
	public String getSuperProcessInstanceId() {
		return superProcessInstanceId;
	}
	public void setSuperProcessInstanceId(String superProcessInstanceId) {
		this.superProcessInstanceId = superProcessInstanceId;
	}
	private String deleteReason;
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	private String tenantId;
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}