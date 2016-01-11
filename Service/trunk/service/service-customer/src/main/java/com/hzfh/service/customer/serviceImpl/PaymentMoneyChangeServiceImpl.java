package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.api.customer.service.PaymentMoneyChangeService;
import com.hzfh.service.customer.dao.PaymentMoneyChangeDao;
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


@Service("paymentMoneyChangeService")
public class PaymentMoneyChangeServiceImpl extends BaseServiceImpl<PaymentMoneyChange, PaymentMoneyChangeCondition, PaymentMoneyChangeDao> implements PaymentMoneyChangeService {
	@Autowired
	private PaymentMoneyChangeDao paymentMoneyChangeDao;
	@Override
	public PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType,
			String requestNo) {
		return paymentMoneyChangeDao.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType,requestNo);
	}
}