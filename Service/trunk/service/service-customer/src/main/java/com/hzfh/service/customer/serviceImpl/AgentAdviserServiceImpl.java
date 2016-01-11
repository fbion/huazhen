package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.service.AgentAdviserService;
import com.hzfh.service.customer.dao.AgentAdviserDao;
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


@Service("agentAdviserService")
public class AgentAdviserServiceImpl extends BaseServiceImpl<AgentAdviser, AgentAdviserCondition, AgentAdviserDao> implements AgentAdviserService {
    @Autowired
    private AgentAdviserDao agentAdviserDao;
    public List<AgentAdviser> getMyAgentAdviser(String workMateString) {
        return agentAdviserDao.getMyAgentAdviser(workMateString);
    }
	@Override
	public List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition) {
		return agentAdviserDao.getNoPagingList(agentAdviserCondition);
	}
	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return agentAdviserDao.updateTradeTotalById(id, tradeTotal);
	}
    @Override
    public List<AgentAdviser> getListForExcel(AgentAdviserCondition agentAdviserCondition){
        return agentAdviserDao.getListForExcel(agentAdviserCondition);
    }
}