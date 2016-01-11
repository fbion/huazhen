package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.service.customer.dao.PaymentMoneyWithdrawDao;
import com.hzfh.service.customer.mapper.PaymentMoneyWithdrawMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("paymentMoneyWithdrawDao")
public class PaymentMoneyWithdrawDaoImpl extends BaseDaoImpl<PaymentMoneyWithdraw, PaymentMoneyWithdrawCondition, PaymentMoneyWithdrawMapper> implements PaymentMoneyWithdrawDao {

	@Autowired
	private PaymentMoneyWithdrawMapper paymentMoneyWithdrawMapper;
	@Override
	public int updateMoneyAmount(double money, String sn) {
		return paymentMoneyWithdrawMapper.updateMoneyAmount(money,sn);
	}

	@Override
	public int updateState(String stateNo, String sn) {
		return paymentMoneyWithdrawMapper.updateState(stateNo,sn);
	}

	@Override
	public PaymentMoneyWithdraw getbySn(String sn) {
		return paymentMoneyWithdrawMapper.getbySn(sn);
	}

	@Override
	public int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw) {
		return paymentMoneyWithdrawMapper.updateWithdraw(paymentMoneyWithdraw);
	}

	@Override
	public PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn) {
		return paymentMoneyWithdrawMapper.getInfoBystateAndSn(status,sn);
	}
}