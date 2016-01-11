package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class FixedAssets extends BaseEntity implements Serializable {
	private int assetType;
	public int getAssetType() {
		return assetType;
	}
	public void setAssetType(int assetType) {
		this.assetType = assetType;
	}
	private String assetId;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	private String assetName;
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	private String brand;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	private String model;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	private String cPU;
	public String getCPU() {
		return cPU;
	}
	public void setCPU(String cPU) {
		this.cPU = cPU;
	}
	private String memory;
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	private String hardDisk;
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private double money;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private int location;
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	private int department;
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	private int userNo;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String registrationId;
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}