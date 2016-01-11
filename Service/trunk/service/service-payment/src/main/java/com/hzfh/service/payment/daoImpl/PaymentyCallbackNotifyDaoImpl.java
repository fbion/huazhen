package com.hzfh.service.payment.daoImpl;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzfh.service.payment.dao.PaymentyCallbackNotifyDao;
import com.hzfh.service.payment.mapper.PaymentyCallbackNotifyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("paymentyCallbackNotifyDao")
public class PaymentyCallbackNotifyDaoImpl extends BaseDaoImpl<PaymentyCallbackNotify, PaymentyCallbackNotifyCondition, PaymentyCallbackNotifyMapper> implements PaymentyCallbackNotifyDao {
}