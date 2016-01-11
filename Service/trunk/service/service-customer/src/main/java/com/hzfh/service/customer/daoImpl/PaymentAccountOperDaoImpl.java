package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzfh.service.customer.dao.PaymentAccountOperDao;
import com.hzfh.service.customer.mapper.PaymentAccountOperMapper;
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


@Service("paymentAccountOperDao")
public class PaymentAccountOperDaoImpl extends BaseDaoImpl<PaymentAccountOper, PaymentAccountOperCondition, PaymentAccountOperMapper> implements PaymentAccountOperDao {
}