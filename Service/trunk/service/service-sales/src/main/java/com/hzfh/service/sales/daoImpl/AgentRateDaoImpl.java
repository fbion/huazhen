package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.service.sales.dao.AgentRateDao;
import com.hzfh.service.sales.mapper.AgentRateMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("agentRateDao")
public class AgentRateDaoImpl extends BaseDaoImpl<AgentRate, AgentRateCondition, AgentRateMapper> implements AgentRateDao {

	@Autowired
	private AgentRateMapper agentRateMapper;

	@Override
	public AgentRate getAgentRate(AgentRate agentRate, long money) {
		return agentRateMapper.getAgentRate(agentRate, money);
	}

    @Override
    public List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition) {
        return agentRateMapper.getAgentRateListByCondition(agentRateCondition);
    }

}