package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface PaymentMoneyWithdrawService extends BaseService<PaymentMoneyWithdraw, PaymentMoneyWithdrawCondition> {
	
	int updateMoneyAmount(double money,String sn);
	
	//state 状态(00 提现申请登记（基金监管时用） 01登记成功  02登记失败（基金监管时用）  03支付中（已生成提现流水） 04 提现成功 05提现失败)
	int updateState(String stateNo,String sn);

	PaymentMoneyWithdraw getbySn(String sn);

	int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw);
	PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn);
}