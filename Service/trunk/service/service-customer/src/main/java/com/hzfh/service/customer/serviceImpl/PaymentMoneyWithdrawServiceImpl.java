package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.api.customer.service.PaymentMoneyWithdrawService;
import com.hzfh.service.customer.dao.PaymentMoneyWithdrawDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("paymentMoneyWithdrawService")
public class PaymentMoneyWithdrawServiceImpl extends BaseServiceImpl<PaymentMoneyWithdraw, PaymentMoneyWithdrawCondition, PaymentMoneyWithdrawDao> implements PaymentMoneyWithdrawService {

	@Autowired
    private PaymentMoneyWithdrawDao paymentMoneyWithdrawDao;
	@Override
	public int updateMoneyAmount(double money, String  sn) {
		return paymentMoneyWithdrawDao.updateMoneyAmount(money,sn);
	}

	@Override
	public int updateState(String stateNo, String sn) {
		return paymentMoneyWithdrawDao.updateState(stateNo,sn);
	}

	@Override
	public PaymentMoneyWithdraw getbySn(String sn) {
		return paymentMoneyWithdrawDao.getbySn(sn);
	}

	@Override
	public int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw) {
		return paymentMoneyWithdrawDao.updateWithdraw(paymentMoneyWithdraw);
	}

	@Override
	public PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn) {
		return paymentMoneyWithdrawDao.getInfoBystateAndSn(status,sn);
	}
}