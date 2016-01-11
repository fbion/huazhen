package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentPayType;
import com.hzfh.api.customer.model.query.PaymentPayTypeCondition;
import com.hzfh.api.customer.service.PaymentPayTypeService;
import com.hzfh.service.customer.dao.PaymentPayTypeDao;
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


@Service("paymentPayTypeService")
public class PaymentPayTypeServiceImpl extends BaseServiceImpl<PaymentPayType, PaymentPayTypeCondition, PaymentPayTypeDao> implements PaymentPayTypeService {
}