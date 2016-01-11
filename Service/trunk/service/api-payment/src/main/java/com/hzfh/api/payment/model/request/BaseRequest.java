package com.hzfh.api.payment.model.request;

import com.hzframework.xml.XStreamHandler;

import java.io.Serializable;

public class BaseRequest<T> implements Serializable{
	private String req;
	private String sign;

	public String getReq() {
		return req;
	}

	public void setReq(T req) {
		String xml = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>";
		this.req = xml+XStreamHandler.toXml(req);
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
