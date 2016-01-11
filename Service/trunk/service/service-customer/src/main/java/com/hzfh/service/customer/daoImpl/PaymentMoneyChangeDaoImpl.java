package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.service.customer.dao.PaymentMoneyChangeDao;
import com.hzfh.service.customer.mapper.PaymentMoneyChangeMapper;
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


@Service("paymentMoneyChangeDao")
public class PaymentMoneyChangeDaoImpl extends BaseDaoImpl<PaymentMoneyChange, PaymentMoneyChangeCondition, PaymentMoneyChangeMapper> implements PaymentMoneyChangeDao {
	@Autowired PaymentMoneyChangeMapper paymentMoneyChangeMapper;
	@Override
	public PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType,
			String requestNo) {
		return paymentMoneyChangeMapper.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType,requestNo);
	}
}