package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 取消自动还款授权 接口输入
 * @author Administrator
 *
 */
public class CancelAuthorizeAutoRepaymentRepaymentReq extends CommonController{
	@XStreamAlias("platformUserNo")
	private String platformUserNo;//Y 平台会员编号
	@XStreamAlias("requestNo")
	private String requestNo;//Y 请求流水号
	@XStreamAlias("orderNo")
	private String orderNo;//Y 标的号

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
