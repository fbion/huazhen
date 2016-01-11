package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PaymentMoneyRechargeDao extends BaseDao<PaymentMoneyRecharge, PaymentMoneyRechargeCondition> {

	List<PaymentMoneyRecharge> getListByCustomerNo(int customerNo);

	int updateRechargeType(int typeNo, int customerNo,String snNo);

	int updatePayType(int typeNo, int customerNo,String snNo);

	int updateMoneyAmount(double money, int customerNo,String snNo);

	int updateState(String stateNo, int customerNo,String snNo);

	PaymentMoneyRecharge getbySn(String sn);

	int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge);

	Double getRechargeMoneyByCustomerNoAndStatusAndToday(int customerNo,
			String status);
	PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn);

	int updateStateBySn(String sn, String state);
}