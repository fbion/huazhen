package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.api.sales.service.AgentRateService;
import com.hzfh.service.sales.dao.AgentRateDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("agentRateService")
public class AgentRateServiceImpl extends BaseServiceImpl<AgentRate, AgentRateCondition, AgentRateDao> implements AgentRateService {
	@Autowired
	private AgentRateDao agentRateDao;
	@Override
	public AgentRate getAgentRate(AgentRate agentRate, long money) {
		return agentRateDao.getAgentRate(agentRate,money);
	}
	@Override
	public List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition) {
		return agentRateDao.getAgentRateListByCondition(agentRateCondition);
	}

}