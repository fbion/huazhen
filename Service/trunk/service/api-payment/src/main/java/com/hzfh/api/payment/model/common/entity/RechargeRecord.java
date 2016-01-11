package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("record")
public class RechargeRecord {
	@XStreamAlias("amount")
	private String amount;//Y 充值金额
	@XStreamAlias("userNo")
	private String userNo;//Y 充值用户
	@XStreamAlias("createTime")
	private String createTime;//Y 充值时间
	@XStreamAlias("status")
	private String status;//Y 充值状态： INIT未付, SUCCESS付款成功

	@XStreamAlias("payProduct")
	private String payProduct;
	@XStreamAlias("fee")
	private String fee;
	@XStreamAlias("feeMode")
	private String feeMode;
	public String getPayProduct() {
		return payProduct;
	}

	public void setPayProduct(String payProduct) {
		this.payProduct = payProduct;
	}

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

}
