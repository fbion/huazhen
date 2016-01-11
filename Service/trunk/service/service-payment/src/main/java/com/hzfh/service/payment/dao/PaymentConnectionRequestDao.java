package com.hzfh.service.payment.dao;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.query.PaymentConnectionRequestCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface PaymentConnectionRequestDao extends BaseDao<PaymentConnectionRequest, PaymentConnectionRequestCondition> {
}