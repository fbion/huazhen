
package com.hzfh.service.customer.serviceImpl;
import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.model.query.PaymentMoneyFreezeCondition;
import com.hzfh.api.customer.service.PaymentMoneyFreezeService;
import com.hzfh.service.customer.dao.PaymentMoneyFreezeDao;
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


@Service("paymentMoneyFreezeService")
public class PaymentMoneyFreezeServiceImpl extends BaseServiceImpl<PaymentMoneyFreeze, PaymentMoneyFreezeCondition, PaymentMoneyFreezeDao> implements PaymentMoneyFreezeService {
	@Autowired
	private PaymentMoneyFreezeDao paymentMoneyFreezeDao;
	@Override
	public PaymentMoneyFreeze getInfoBySnAndType(String refSn,byte type) {
		return paymentMoneyFreezeDao.getInfoBySnAndType(refSn,type);
	}
}