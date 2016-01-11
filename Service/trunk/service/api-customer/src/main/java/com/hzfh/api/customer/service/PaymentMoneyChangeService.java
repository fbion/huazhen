package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
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


public interface PaymentMoneyChangeService extends BaseService<PaymentMoneyChange, PaymentMoneyChangeCondition> {
	PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType,
			String requestNo);
}