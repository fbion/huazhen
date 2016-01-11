package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
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


public class ActivityCustomerPresent extends BaseEntity implements Serializable {
	private int presentNo;
	public int getPresentNo() {
		return presentNo;
	}
	public void setPresentNo(int presentNo) {
		this.presentNo = presentNo;
	}
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private String recipient;
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private int provinceNo;
	public int getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}
	private int cityNo;
	public int getCityNo() {
		return cityNo;
	}
	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}
	private int districtNo;
	public int getDistrictNo() {
		return districtNo;
	}
	public void setDistrictNo(int districtNo) {
		this.districtNo = districtNo;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private Timestamp acquisitionTime;
	public Timestamp getAcquisitionTime() {
		return acquisitionTime;
	}
	public void setAcquisitionTime(Timestamp acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int myActivityNo;
	public int getMyActivityNo() {
		return myActivityNo;
	}
	public void setMyActivityNo(int myActivityNo) {
		this.myActivityNo = myActivityNo;
	}
}