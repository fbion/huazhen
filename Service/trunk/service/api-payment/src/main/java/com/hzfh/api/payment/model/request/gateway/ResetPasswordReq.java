package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 *重置密码
 *	Action名称 toResetPassword
 *	支持properties N
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class ResetPasswordReq extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo; 	//请求流水号
	@XStreamAlias("platformUserNo")
	private String platformUserNo;	//平台用户编号
	@XStreamAlias("callbackUrl")
	private String callbackUrl;	//页面回跳URL
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
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	

}
