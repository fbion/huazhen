package com.hzfh.api.payment.model.request;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

public class CommonController implements Serializable{
	@XStreamAsAttribute
    private String platformNo;	//商户编号

	public String getPlatformNo() {
		return this.platformNo;//在测试环境中，各接入商户均使用10040011137作为platformNo
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = "10012459931";
	}
	
}
