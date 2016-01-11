package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

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


public interface PaymentMoneyRechargeService extends BaseService<PaymentMoneyRecharge, PaymentMoneyRechargeCondition> {

	List<PaymentMoneyRecharge> getListByCustomerNo(int customerNo);
	
	int updateRechargeType(int typeNo,int customerNo,String snNo);
	
	int updatePayType(int typeNo,int customerNo,String snNo);
	
	int updateMoneyAmount(double money,int customerNo,String snNo);
	
	//state  01充值成功 02 充值失败
	@Deprecated
	int updateState(String stateNo,int customerNo,String snNo);

	int updateStateBySn(String sn,String state);
	
	PaymentMoneyRecharge getbySn(String sn);

	int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge);

	Double getRechargeMoneyByCustomerNoAndStatusAndToday(int customerNo,
			String status);

	PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn);
	
	
	
	
	
}