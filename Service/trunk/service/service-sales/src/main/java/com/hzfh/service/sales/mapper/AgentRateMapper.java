package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("agentRateMapper")
public interface AgentRateMapper extends BaseMapper<AgentRate, AgentRateCondition> {
	//Double getAgentRate(@Param("agentRate")AgentRate agentRate, @Param("money")int money);
	AgentRate getAgentRate(@Param("agentRate")AgentRate agentRate, @Param("money")long money);

    List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition);
}