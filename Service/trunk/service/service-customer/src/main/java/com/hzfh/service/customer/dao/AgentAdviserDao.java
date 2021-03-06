package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
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


public interface AgentAdviserDao extends BaseDao<AgentAdviser, AgentAdviserCondition> {
    List<AgentAdviser> getMyAgentAdviser(String workMateString);

	List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition);
	int updateTradeTotalById(int id, double tradeTotal);

    List<AgentAdviser> getListForExcel(AgentAdviserCondition agentAdviserCondition);
}