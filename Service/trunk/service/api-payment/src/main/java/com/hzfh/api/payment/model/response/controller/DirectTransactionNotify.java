package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 直接转账 回调通知
 * @author Administrator
 *
 */
@XStreamAlias("notify")
public class DirectTransactionNotify extends CommonController{
	@XStreamAlias("bizType")
	private String bizType;//Y 固定值TRANSACTION
	@XStreamAlias("code")
	private String code;//N 【见返回码】
	@XStreamAlias("message")
	private String message;//N 描述信息
	@XStreamAlias("status")
	private String status;//N 固定值：DIRECT
	@XStreamAlias("requestNo")
	private String requestNo;//N 请求流水号
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	
}
