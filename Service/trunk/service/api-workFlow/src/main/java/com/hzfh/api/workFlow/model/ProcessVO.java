package com.hzfh.api.workFlow.model;

public class ProcessVO {
	private String proInId;//流程实例Id
	private String title;//申请标题
	private String requestDate;//申请日期
	public String getProInId() {
		return proInId;
	}
	public void setProInId(String proInId) {
		this.proInId = proInId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
}
