package com.hzfh.p2p.controller.baseInfo;

import com.hzfh.api.employee.model.Department;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DepartmentModel;

/**
 * Created by Administrator on 2015/6/4.
 */
public class BaiduMap extends CommonAction {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private double longitude;
	private double latitude;
	private String title;
	private String telephone;
	private String address;
	public String getTitle() {
		return title;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getAddress() {
		return address;
	}
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	
	@Override
	public String execute() {
		Department department = DepartmentModel.getInfo(id);
		longitude = department.getLongitude();
		latitude = department.getLatitude();
		title = department.getName();
		telephone = department.getTelephone();
		address = department.getAddress();
		return SUCCESS;
	}
}
