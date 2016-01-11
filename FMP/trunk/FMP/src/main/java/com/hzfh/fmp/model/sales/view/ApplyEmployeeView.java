package com.hzfh.fmp.model.sales.view;

import com.hzfh.api.sales.model.ApplyEmployee;


/**
 * Created by paul on 15-4-29.
 */
public class ApplyEmployeeView extends ApplyEmployee {
    public ApplyEmployeeView(ApplyEmployee applyEmployee) {
    	this.setActivityNo(applyEmployee.getActivityNo());
    	this.setName(applyEmployee.getName());
    	this.setSex(applyEmployee.getSex());
    	this.setTel(applyEmployee.getTel());
    	this.setIsSign(applyEmployee.getIsSign());
    	
    }
    private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	private int parentNo;
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private int isInvite;
	public int getIsInvite() {
		return isInvite;
	}
	public void setIsInvite(int isInvite) {
		this.isInvite = isInvite;
	}
	private int inviteNum;
	public int getInviteNum() {
		return inviteNum;
	}
	public void setInviteNum(int inviteNum) {
		this.inviteNum = inviteNum;
	}
	private int arriveNum;
	public int getArriveNum() {
		return arriveNum;
	}
	public void setArriveNum(int arriveNum) {
		this.arriveNum = arriveNum;
	}
	private int isSign;
	public int getIsSign() {
		return isSign;
	}
	public void setIsSign(int isSign) {
		this.isSign = isSign;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private String tel;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private byte sex;
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	
	
	
	
	
	
   
}
