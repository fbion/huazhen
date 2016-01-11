package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.BrokerageCalculate;
import com.hzfh.api.sales.model.query.BrokerageCalculateCondition;
import com.hzfh.service.sales.dao.BrokerageCalculateDao;
import com.hzfh.service.sales.mapper.BrokerageCalculateMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("brokerageCalculateDao")
public class BrokerageCalculateDaoImpl extends BaseDaoImpl<BrokerageCalculate, BrokerageCalculateCondition, BrokerageCalculateMapper> implements BrokerageCalculateDao {
}