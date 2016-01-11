package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.api.customer.model.query.PaymentPlatformCondition;
import com.hzfh.api.customer.service.PaymentPlatformService;
import com.hzfh.service.customer.dao.PaymentPlatformDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("paymentPlatformService")
public class PaymentPlatformServiceImpl extends BaseServiceImpl<PaymentPlatform, PaymentPlatformCondition, PaymentPlatformDao> implements PaymentPlatformService {
}