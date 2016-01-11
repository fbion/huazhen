package com.hzfh.api.log.model;


import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/26 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Log extends BaseEntity implements Serializable {
	private String businessNumber;
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	private String level;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	private String operateName;
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	private String supplement;
	public String getSupplement() {
		return supplement;
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}
	private String accessUrl;
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	private String forwardUrl;
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	private String projectName;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	private String className;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	private String methodName;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	private String userIdentifierCode;
	public String getUserIdentifierCode() {
		return userIdentifierCode;
	}
	public void setUserIdentifierCode(String userIdentifierCode) {
		this.userIdentifierCode = userIdentifierCode;
	}
	private int userNo;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private String startTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	private String endTime;
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	private String hostIp;
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	private String requestType;
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	private String exceptionMsg;
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	private String paramIn;
	public String getParamIn() {
		return paramIn;
	}
	public void setParamIn(String paramIn) {
		this.paramIn = paramIn;
	}
	private String paramOut;
	public String getParamOut() {
		return paramOut;
	}
	public void setParamOut(String paramOut) {
		this.paramOut = paramOut;
	}
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String browser;
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
}