package com.hzfh.api.payment.model.response.gateway;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("notify")
public class AuthorizeAutoTransferNotify extends CommonController{
	@XStreamAlias("bizType")
	private String bizType;			//Y 固定值REGISTER
	@XStreamAlias("code")
	private String code;			//Y 【见返回码】
	@XStreamAlias("message")
	private String message;			//N 描述异常信息
	@XStreamAlias("platformUserNo")
	private String platformUserNo;	//Y 平台的用户编号 

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

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

}
