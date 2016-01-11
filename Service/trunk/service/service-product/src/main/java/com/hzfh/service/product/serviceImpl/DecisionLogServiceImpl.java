package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.DecisionLog;
import com.hzfh.api.product.model.query.DecisionLogCondition;
import com.hzfh.api.product.service.DecisionLogService;
import com.hzfh.service.product.dao.DecisionLogDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("decisionLogService")
public class DecisionLogServiceImpl extends BaseServiceImpl<DecisionLog, DecisionLogCondition, DecisionLogDao> implements DecisionLogService {
}