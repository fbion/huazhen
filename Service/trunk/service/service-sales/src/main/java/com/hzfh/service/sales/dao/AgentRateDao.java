package com.hzfh.service.sales.dao;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

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


public interface AgentRateDao extends BaseDao<AgentRate, AgentRateCondition> {

	AgentRate getAgentRate(AgentRate agentRate, long money);

    List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition);
}