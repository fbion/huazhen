package com.hzfh.service.payment.daoImpl;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.query.PaymentConnectionRequestCondition;
import com.hzfh.service.payment.dao.PaymentConnectionRequestDao;
import com.hzfh.service.payment.mapper.PaymentConnectionRequestMapper;
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


@Service("paymentConnectionRequiredDao")
public class PaymentConnectionRequestDaoImpl extends BaseDaoImpl<PaymentConnectionRequest, PaymentConnectionRequestCondition, PaymentConnectionRequestMapper> implements PaymentConnectionRequestDao {
}