package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.DecisionLog;
import com.hzfh.api.product.model.query.DecisionLogCondition;
import com.hzfh.service.product.dao.DecisionLogDao;
import com.hzfh.service.product.mapper.DecisionLogMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("decisionLogDao")
public class DecisionLogDaoImpl extends BaseDaoImpl<DecisionLog, DecisionLogCondition, DecisionLogMapper> implements DecisionLogDao {
}