package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class UnbindBankCardReq extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo;
	@XStreamAlias("callbackUrl")
	private String callbackUrl;
	@XStreamAlias("platformUserNo")
	private String platformUserNo;
	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

}
