package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Activity extends BaseEntity implements Serializable {
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private Date activityTime;
	public Date getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	private String empName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private int peopleNum;
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private int publisher;
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	private Date publisherTime;
	public Date getPublisherTime() {
		return publisherTime;
	}
	public void setPublisherTime(Date publisherTime) {
		this.publisherTime = publisherTime;
	}
	private int applyEmpNum;
	public int getApplyEmpNum() {
		return applyEmpNum;
	}
	public void setApplyEmpNum(int applyEmpNum) {
		this.applyEmpNum = applyEmpNum;
	}
	private int applyCustomerNum;
	public int getApplyCustomerNum() {
		return applyCustomerNum;
	}
	public void setApplyCustomerNum(int applyCustomerNum) {
		this.applyCustomerNum = applyCustomerNum;
	}
	private int arriveEmpNum;
	public int getArriveEmpNum() {
		return arriveEmpNum;
	}
	public void setArriveEmpNum(int arriveEmpNum) {
		this.arriveEmpNum = arriveEmpNum;
	}
	private int arriveCustomerNum;
	public int getArriveCustomerNum() {
		return arriveCustomerNum;
	}
	public void setArriveCustomerNum(int arriveCustomerNum) {
		this.arriveCustomerNum = arriveCustomerNum;
	}
	private double longitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	private double latitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}