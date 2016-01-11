package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PaymentMoneyWithdrawDao extends BaseDao<PaymentMoneyWithdraw, PaymentMoneyWithdrawCondition> {

	int updateMoneyAmount(double money, String sn);

	int updateState(String stateNo, String sn);

	PaymentMoneyWithdraw getbySn(String sn);

	int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw);

	PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn);
}