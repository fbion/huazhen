package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 项目(标的)查询 接口输入
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class ProjectQueryReq extends CommonController{
	@XStreamAlias("orderNo")
	private String orderNo;//Y 标的号

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
