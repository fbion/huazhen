package com.hzfh.api.payment.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ControllerRequest<T> extends BaseRequest<T> {
	@XStreamAlias("service")
	private String service;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
