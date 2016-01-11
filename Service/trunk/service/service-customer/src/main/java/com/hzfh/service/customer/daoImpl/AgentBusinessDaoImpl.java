package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.service.customer.dao.AgentBusinessDao;
import com.hzfh.service.customer.mapper.AgentBusinessMapper;
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


@Service("agentBusinessDao")
public class AgentBusinessDaoImpl extends BaseDaoImpl<AgentBusiness, AgentBusinessCondition, AgentBusinessMapper> implements AgentBusinessDao {
    @Autowired
    private AgentBusinessMapper agentBusinessMapper;
    @Override
    public List<AgentBusiness> getMyAgentBusiness(String workMateString) {
        return agentBusinessMapper.getMyAgentBusiness(workMateString);
    }
	@Override
	public List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition) {
		return agentBusinessMapper.getNoPagingList(agentBusinessCondition);
	}
	@Override
	public List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo) {
		  return agentBusinessMapper.getAgentBusinessListByManageNo(mamageNo);
	}
	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return agentBusinessMapper.updateTradeTotalById(id,tradeTotal);
	}

    @Override
    public List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition){
        return agentBusinessMapper.getListForExcel(agentBusinessCondition);
    }
}