package com.hzfh.api.payment.model.common.constant;

public enum ServiceStates 
{
	TENDER,	//投标
	REPAYMENT,//还款
	CREDIT_ASSIGNMENT,//债权转让
	TRANSFER,//转账
	COMMISSION//分润，仅在资金转账明细中使用
}
