package com.hzfh.api.payment.model.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PaymentData implements Serializable{
	private String url;
	private String sign;
	private String xml;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	
	
}
