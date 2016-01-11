package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
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


public interface AgentBusinessService extends BaseService<AgentBusiness, AgentBusinessCondition> {
    List<AgentBusiness> getMyAgentBusiness(String workMateString);

	List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition);

	List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo);
	int updateTradeTotalById(int id, double tradeTotal);

    List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition);
}