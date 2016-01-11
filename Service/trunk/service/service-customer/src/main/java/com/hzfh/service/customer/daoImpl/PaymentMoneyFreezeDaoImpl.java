package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.model.query.PaymentMoneyFreezeCondition;
import com.hzfh.service.customer.dao.PaymentMoneyFreezeDao;
import com.hzfh.service.customer.mapper.PaymentMoneyFreezeMapper;
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


@Service("paymentMoneyFreezeDao")
public class PaymentMoneyFreezeDaoImpl extends BaseDaoImpl<PaymentMoneyFreeze, PaymentMoneyFreezeCondition, PaymentMoneyFreezeMapper> implements PaymentMoneyFreezeDao {
	@Autowired
	private PaymentMoneyFreezeMapper paymentMoneyFreezeMapper;
	@Override
	public PaymentMoneyFreeze getInfoBySnAndType(String refSn,byte type) {
		return paymentMoneyFreezeMapper.getInfoBySnAndType(refSn,type);
	}
}