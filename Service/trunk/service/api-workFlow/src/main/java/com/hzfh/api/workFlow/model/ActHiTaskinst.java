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


public class ActHiTaskinst extends BaseEntity implements Serializable {
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	private String procDefId;
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	private String taskDefKey;
	public String getTaskDefKey() {
		return taskDefKey;
	}
	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}
	private String procInstId;
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	private String executionId;
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String parentTaskId;
	public String getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	private String assignee;
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	private Timestamp startTime;
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	private Timestamp claimTime;
	public Timestamp getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Timestamp claimTime) {
		this.claimTime = claimTime;
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
	private String deleteReason;
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	private int priority;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	private Timestamp dueDate;
	public Timestamp getDueDate() {
		return dueDate;
	}
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}
	private String formKey;
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private String tenantId;
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}