package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class PlatformInfoReq extends CommonController{
	@XStreamAlias("notifyUrl")
	private String notifyUrl;//Y异步通知地址(用亍接收银行验证卡片结果，即绑卡成功或失败状态，通知参数格式详见2.4.3绑卡回调通知)

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	  
}
