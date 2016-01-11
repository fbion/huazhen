package com.hzfh.api.payment.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class CommonRequest extends CommonController{
	@XStreamAlias("platformUserNo")
	private String platformUserNo;	//平台用户编号
	@XStreamAlias("requestNo")
	private String requestNo; 	//请求流水号
	@XStreamAlias("callbackUrl")
	private String callbackUrl;	//页面回跳URL
	@XStreamAlias("notifyUrl")
	private String notifyUrl;	//服务器通知URL

	public String getPlatformUserNo() {
		return platformUserNo;
	}
	/**
	 * @param platformUserNo N 平台用户编号 String
	 */
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRequestNo() {
		return requestNo;
	}

	/**
	 * @param requestNo N 请求流水号 String
	 */
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * @param callbackUrl N 页面回跳URL String
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}
	/**
	 * @param notifyUrl N 服务器通知URL String
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
}
