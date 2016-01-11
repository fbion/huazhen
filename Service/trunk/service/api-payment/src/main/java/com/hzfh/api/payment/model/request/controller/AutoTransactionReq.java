package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.common.entity.Detail;
import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;
@XStreamAlias("request")
public class AutoTransactionReq extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo;//Y 请求流水号
	@XStreamAlias("platformUserNo")
	private String platformUserNo;//Y 出款人用户编号，目前只支持传入平台商户编号
	@XStreamAlias("userType")
	private String userType;//Y 出款人用户类型，目前只支持传入MERCHANT
	@XStreamAlias("bizType")
	private String bizType;//Y 目前只支持传入TRANSFER
	@XStreamImplicit(itemFieldName="details")  
	private List<Detail> details;//Y 资金明细记录      
	@XStreamAlias("notifyUrl")
	private String notifyUrl;//Y 服务器通知URL
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

}
