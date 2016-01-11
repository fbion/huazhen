package com.hzfh.api.payment.model.request.controller;
import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class AccountInfoReq extends CommonController{
	@XStreamAlias("platformUserNo")
	private String platformUserNo;//Y 平台会员编号

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

}
