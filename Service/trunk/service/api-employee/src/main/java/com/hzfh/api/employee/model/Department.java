package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Department extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String fax;
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private byte deptType;
	public byte getDeptType() {
		return deptType;
	}
	public void setDeptType(byte deptType) {
		this.deptType = deptType;
	}
	private String duty;
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	private int parentNo;
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	private int provinceNo;
	private int directStatus;

	public int getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}
	public int getDirectStatus() {
		return directStatus;
	}
	public void setDirectStatus(int directStatus) {
		this.directStatus = directStatus;
	}
    private int cityNo;
    private int districtNo;

    public int getDistrictNo() {
        return districtNo;
    }
    public void setDistrictNo(int districtNo) {
        this.districtNo = districtNo;
    }
    public int getCityNo() {
        return cityNo;
    }
    public void setCityNo(int cityNo) {
        this.cityNo = cityNo;
    }

	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private String departmentImagePath;
	public String getDepartmentImagePath() {
		return departmentImagePath;
	}
	public void setDepartmentImagePath(String departmentImagePath) {
		this.departmentImagePath = departmentImagePath;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String locationImagePath;
	public String getLocationImagePath() {
		return locationImagePath;
	}
	public void setLocationImagePath(String locationImagePath) {
		this.locationImagePath = locationImagePath;
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