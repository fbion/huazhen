package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
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


public interface PaymentMoneyChangeDao extends BaseDao<PaymentMoneyChange, PaymentMoneyChangeCondition> {

	
	PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType,
			String requestNo);
}