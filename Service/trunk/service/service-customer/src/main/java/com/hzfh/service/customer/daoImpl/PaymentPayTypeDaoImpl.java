package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentPayType;
import com.hzfh.api.customer.model.query.PaymentPayTypeCondition;
import com.hzfh.service.customer.dao.PaymentPayTypeDao;
import com.hzfh.service.customer.mapper.PaymentPayTypeMapper;
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


@Service("paymentPayTypeDao")
public class PaymentPayTypeDaoImpl extends BaseDaoImpl<PaymentPayType, PaymentPayTypeCondition, PaymentPayTypeMapper> implements PaymentPayTypeDao {
}