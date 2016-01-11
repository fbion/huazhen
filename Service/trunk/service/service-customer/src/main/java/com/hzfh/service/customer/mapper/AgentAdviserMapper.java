package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
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


@Service("agentAdviserMapper")
public interface AgentAdviserMapper extends BaseMapper<AgentAdviser, AgentAdviserCondition> {
    List<AgentAdviser> getMyAgentAdviser(@Param("workMateString")String workMateString);

	List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition);
	
	int updateTradeTotalById(@Param("id")int id,@Param("tradeTotal") double tradeTotal);

    List<AgentAdviser> getListForExcel(AgentAdviserCondition agentAdviserCondition);
}