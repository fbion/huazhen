package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.BrokerageCalculate;
import com.hzfh.api.sales.model.query.BrokerageCalculateCondition;
import com.hzfh.api.sales.service.BrokerageCalculateService;
import com.hzfh.service.sales.dao.BrokerageCalculateDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("brokerageCalculateService")
public class BrokerageCalculateServiceImpl extends BaseServiceImpl<BrokerageCalculate, BrokerageCalculateCondition, BrokerageCalculateDao> implements BrokerageCalculateService {
}