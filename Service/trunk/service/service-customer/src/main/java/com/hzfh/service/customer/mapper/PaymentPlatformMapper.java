package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.api.customer.model.query.PaymentPlatformCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("paymentPlatformMapper")
public interface PaymentPlatformMapper extends BaseMapper<PaymentPlatform, PaymentPlatformCondition> {
}