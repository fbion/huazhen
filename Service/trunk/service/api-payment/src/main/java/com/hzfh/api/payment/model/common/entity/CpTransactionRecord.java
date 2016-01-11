package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 单笔业务查询   转账记录
 * @author Administrator
 *
 */
@XStreamAlias("record")
public class CpTransactionRecord implements Serializable{
	@XStreamAlias("requestNo")
	private String requestNo;//流水号
	@XStreamAlias("bizType")
	private String bizType;//业务类型
	@XStreamAlias("amount")
	private String amount;//转账总金额
	@XStreamAlias("status")
	private String status;//订单状态：PREAUTH已授权。CONFIRM：已确讣出款。CANCEL：已取消。DIRECT：直接划转。
	@XStreamAlias("subStatus")
	private String subStatus;//处理状态 : PROCESSING：处理中。SUCCESS：成功。ERROR：异常。FAIL：失败
	@XStreamAlias("sourceUserType")
	private String sourceUserType;
	@XStreamAlias("sourceUserNo")
	private String sourceUserNo;
	@XStreamAlias("createdTime")
	private String createdTime;
	
	public String getSourceUserType() {
		return sourceUserType;
	}
	public void setSourceUserType(String sourceUserType) {
		this.sourceUserType = sourceUserType;
	}
	public String getSourceUserNo() {
		return sourceUserNo;
	}
	public void setSourceUserNo(String sourceUserNo) {
		this.sourceUserNo = sourceUserNo;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	
}
