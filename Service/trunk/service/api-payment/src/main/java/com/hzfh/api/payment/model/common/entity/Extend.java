package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;
@XStreamAlias("extend")
public class Extend extends CommonEntity{
	@XStreamImplicit(itemFieldName="property",keyFieldName = "name")
	private Map<String, Property> property;

	public Map<String, Property> getProperty() {
		return property;
	}

	public void setProperty(Map<String, Property> property) {
		this.property = property;
	}
	
}
