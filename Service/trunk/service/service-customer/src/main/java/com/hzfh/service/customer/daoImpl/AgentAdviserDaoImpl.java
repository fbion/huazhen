package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.service.customer.dao.AgentAdviserDao;
import com.hzfh.service.customer.mapper.AgentAdviserMapper;
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


@Service("agentAdviserDao")
public class AgentAdviserDaoImpl extends BaseDaoImpl<AgentAdviser, AgentAdviserCondition, AgentAdviserMapper> implements AgentAdviserDao {
    @Autowired
    private AgentAdviserMapper agentAdviserMapper;
    @Override
    public List<AgentAdviser> getMyAgentAdviser(String workMateString) {
        return agentAdviserMapper.getMyAgentAdviser(workMateString);
    }
	@Override
	public List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition) {
		return agentAdviserMapper.getNoPagingList(agentAdviserCondition);
	}
	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return agentAdviserMapper.updateTradeTotalById(id,tradeTotal);
	}

    @Override
    public List<AgentAdviser> getListForExcel(AgentAdviserCondition agentAdviserCondition){
        return agentAdviserMapper.getListForExcel(agentAdviserCondition);
    }
}