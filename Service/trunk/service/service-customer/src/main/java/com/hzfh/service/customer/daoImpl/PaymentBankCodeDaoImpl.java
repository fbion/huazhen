package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentBankCode;
import com.hzfh.api.customer.model.query.PaymentBankCodeCondition;
import com.hzfh.service.customer.dao.PaymentBankCodeDao;
import com.hzfh.service.customer.mapper.PaymentBankCodeMapper;
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


@Service("paymentBankCodeDao")
public class PaymentBankCodeDaoImpl extends BaseDaoImpl<PaymentBankCode, PaymentBankCodeCondition, PaymentBankCodeMapper> implements PaymentBankCodeDao {
}