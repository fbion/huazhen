package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface PaymentDao extends BaseDao<Payment, PaymentCondition> {
}