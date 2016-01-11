package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("record")
public class WithdrawRecord implements Serializable{
	@XStreamAlias("amount")
	private String amount;//Y 提现金额
	@XStreamAlias("userNo")
	private String userNo;//Y 提现用户
	@XStreamAlias("createTime")
	private String createTime;//Y 提现时间
	@XStreamAlias("status")
	private String status;//Y 提现状态： INIT, SUCCESS
	@XStreamAlias("remitStatus")
	private String remitStatus;//Y REMIT_SUCCESS打款成功 REMIT_FAILURE打款失败 REMITING打款中

	private String fee;
	private String feeMode;
	
	
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getFeeMode() {
		return feeMode;
	}

	public void setFeeMode(String feeMode) {
		this.feeMode = feeMode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemitStatus() {
		return remitStatus;
	}

	public void setRemitStatus(String remitStatus) {
		this.remitStatus = remitStatus;
	}

}
