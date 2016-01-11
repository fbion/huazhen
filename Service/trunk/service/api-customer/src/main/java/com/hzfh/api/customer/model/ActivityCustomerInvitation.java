package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityCustomerInvitation extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private int invitedNo;
	public int getInvitedNo() {
		return invitedNo;
	}
	public void setInvitedNo(int invitedNo) {
		this.invitedNo = invitedNo;
	}
	private Timestamp registerTime;
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	private Timestamp authenticationTime;
	public Timestamp getAuthenticationTime() {
		return authenticationTime;
	}
	public void setAuthenticationTime(Timestamp authenticationTime) {
		this.authenticationTime = authenticationTime;
	}
	private Timestamp investTime;
	public Timestamp getInvestTime() {
		return investTime;
	}
	public void setInvestTime(Timestamp investTime) {
		this.investTime = investTime;
	}
	private double rewardsMoney;

	public double getRewardsMoney() {
		return rewardsMoney;
	}
	public void setRewardsMoney(double rewardsMoney) {
		this.rewardsMoney = rewardsMoney;
	}
	private Timestamp inviteTime;
	public Timestamp getInviteTime() {
		return inviteTime;
	}
	public void setInviteTime(Timestamp inviteTime) {
		this.inviteTime = inviteTime;
	}
	private int approverNo;
	public int getApproverNo() {
		return approverNo;
	}
	public void setApproverNo(int approverNo) {
		this.approverNo = approverNo;
	}
	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private int activityCustomerCashBonusNo;
	public int getActivityCustomerCashBonusNo() {
		return activityCustomerCashBonusNo;
	}
	public void setActivityCustomerCashBonusNo(int activityCustomerCashBonusNo) {
		this.activityCustomerCashBonusNo = activityCustomerCashBonusNo;
	}
	private String requestNo;
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	private String p2pCustomerName;
	private String invitionStatue;
	public String getP2pCustomerName() {
		return p2pCustomerName;
	}
	public void setP2pCustomerName(String p2pCustomerName) {
		this.p2pCustomerName = p2pCustomerName;
	}
	public String getInvitionStatue() {
		return invitionStatue;
	}
	public void setInvitionStatue(String invitionStatue) {
		this.invitionStatue = invitionStatue;
	}
	private int activityRewardType;
	private int relatedNo;
	public int getActivityRewardType() {
		return activityRewardType;
	}
	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	public int getRelatedNo() {
		return relatedNo;
	}
	public void setRelatedNo(int relatedNo) {
		this.relatedNo = relatedNo;
	}
	private String showRewardsMoney;
	public String getShowRewardsMoney() {
		return showRewardsMoney;
	}
	public void setShowRewardsMoney(String showRewardsMoney) {
		this.showRewardsMoney = showRewardsMoney;
	}

	private String money;
	private double trueMoney;
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public double getTrueMoney() {
		return trueMoney;
	}
	public void setTrueMoney(double trueMoney) {
		this.trueMoney = trueMoney;
	}
	private String invitePhoneNo;
	public String getInvitePhoneNo() {
		return invitePhoneNo;
	}
	public void setInvitePhoneNo(String invitePhoneNo) {
		this.invitePhoneNo = invitePhoneNo;
	}
	
	
	
	
	
	
}