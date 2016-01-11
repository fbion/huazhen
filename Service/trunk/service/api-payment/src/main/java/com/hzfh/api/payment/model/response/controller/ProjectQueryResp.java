package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 项目(标的)查询 接口输出
 * @author Administrator
 *
 */
@XStreamAlias("response")
public class ProjectQueryResp extends CommonController{
	@XStreamAlias("code")
	private String code;//Y 【见返回码】
	@XStreamAlias("description")
	private String description;//Y 描述信息
	@XStreamAlias("targetPlatformUserNo")
	private String targetPlatformUserNo;//Y 项目借款方平台用户编号
	@XStreamAlias("targetUserType")
	private String targetUserType;//Y 项目借款方用户类型
	@XStreamAlias("transferAmount")
	private String transferAmount;//Y 项目金额
	@XStreamAlias("autoRepayment")
	private String autoRepayment;//Y 是否可以自劢还款
	@XStreamAlias("createTime")
	private String createTime;//Y 项目创建时间
	@XStreamAlias("notifyUrl")
	private String notifyUrl;//Y 异步通知地址
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTargetPlatformUserNo() {
		return targetPlatformUserNo;
	}
	public void setTargetPlatformUserNo(String targetPlatformUserNo) {
		this.targetPlatformUserNo = targetPlatformUserNo;
	}
	public String getTargetUserType() {
		return targetUserType;
	}
	public void setTargetUserType(String targetUserType) {
		this.targetUserType = targetUserType;
	}
	public String getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getAutoRepayment() {
		return autoRepayment;
	}
	public void setAutoRepayment(String autoRepayment) {
		this.autoRepayment = autoRepayment;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	

}
