package com.hzfh.service.payment.mapper;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("paymentyCallbackNotifyMapper")
public interface PaymentyCallbackNotifyMapper extends BaseMapper<PaymentyCallbackNotify, PaymentyCallbackNotifyCondition> {
}