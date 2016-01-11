package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzfh.api.payment.service.PaymentyCallbackNotifyService;
import com.hzfh.service.payment.dao.PaymentyCallbackNotifyDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("paymentyCallbackNotifyService")
public class PaymentyCallbackNotifyServiceImpl extends BaseServiceImpl<PaymentyCallbackNotify, PaymentyCallbackNotifyCondition, PaymentyCallbackNotifyDao> implements PaymentyCallbackNotifyService {
}