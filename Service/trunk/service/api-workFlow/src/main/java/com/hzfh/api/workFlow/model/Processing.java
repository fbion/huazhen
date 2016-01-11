package com.hzfh.api.workFlow.model;

import java.util.Date;

public class Processing {
	private String id;//流程实例Id
	private String title;//申请标题
	private String requestDate;//申请日期
	private String requestUser;//请求人
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private String endDate;//结束日期
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private  String uri;

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getRequestUser() {
		return requestUser;
	}
	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}
	
	
}
