package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class WhdebitnocardRechargeReq extends CommonController{
	@XStreamAlias("requestNo")
    private String requestNo;//Y请求流水号
	@XStreamAlias("platformUserNo")
    private String platformUserNo;//Y平台用户编号
	@XStreamAlias("payWay")
    private String payWay;//Y【见代扣银行编码】
	@XStreamAlias("amount")
    private String amount;//Y充值金额
	@XStreamAlias("feeMode")
    private String feeMode;//Y固定值platform
	@XStreamAlias("realName")
    private String realName;//Y真实姓名
	@XStreamAlias("idCardNo")
    private String idCardNo;//Y身份证号
	@XStreamAlias("bankCardNo")
    private String bankCardNo;//Y验证通过的卡号
	@XStreamAlias("notifyUrl")
    private String notifyUrl;//Y服务器通知URL
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFeeMode() {
		return feeMode;
	}
	public void setFeeMode(String feeMode) {
		this.feeMode = feeMode;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
    
}
