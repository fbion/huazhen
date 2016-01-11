package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
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


public interface AgentBusinessDao extends BaseDao<AgentBusiness, AgentBusinessCondition> {
    List<AgentBusiness> getMyAgentBusiness(String workMateString);

	List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition);

	List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo);
	int updateTradeTotalById(int id, double tradeTotal);

    List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition);
}