package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("detail")
public class Detail extends CommonEntity{
	@XStreamAlias("amount")
	private String amount; // Y 转入金额
	@XStreamAlias("targetUserType")
	private String targetUserType;// Y 用户类型, 见【用户类型】
	@XStreamAlias("targetPlatformUserNo")
	private String targetPlatformUserNo; // Y 平台用户编号
	@XStreamAlias("bizType")
	private String bizType; // Y 资金明细业务类型。根据业务的丌同，需要传入丌同的值，见【业务类型】

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTargetUserType() {
		return targetUserType;
	}

	public void setTargetUserType(String targetUserType) {
		this.targetUserType = targetUserType;
	}

	public String getTargetPlatformUserNo() {
		return targetPlatformUserNo;
	}

	public void setTargetPlatformUserNo(String targetPlatformUserNo) {
		this.targetPlatformUserNo = targetPlatformUserNo;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}
