package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.api.customer.model.query.PaymentPlatformCondition;
import com.hzfh.service.customer.dao.PaymentPlatformDao;
import com.hzfh.service.customer.mapper.PaymentPlatformMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("paymentPlatformDao")
public class PaymentPlatformDaoImpl extends BaseDaoImpl<PaymentPlatform, PaymentPlatformCondition, PaymentPlatformMapper> implements PaymentPlatformDao {
}