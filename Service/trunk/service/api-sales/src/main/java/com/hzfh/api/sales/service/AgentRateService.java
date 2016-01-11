package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzframework.data.service.BaseService;

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


public interface AgentRateService extends BaseService<AgentRate, AgentRateCondition> {

	AgentRate getAgentRate(AgentRate agentRate, long money);

	List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition);

}