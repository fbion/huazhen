package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.api.customer.service.AgentBusinessService;
import com.hzfh.service.customer.dao.AgentBusinessDao;
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


@Service("agentBusinessService")
public class AgentBusinessServiceImpl extends BaseServiceImpl<AgentBusiness, AgentBusinessCondition, AgentBusinessDao> implements AgentBusinessService {
    @Autowired
    private AgentBusinessDao agentBusinessDao;
    @Override
    public List<AgentBusiness> getMyAgentBusiness(String workMateString) {
        return agentBusinessDao.getMyAgentBusiness(workMateString);
    }
	@Override
	public List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition) {
		return agentBusinessDao.getNoPagingList(agentBusinessCondition);
	}
	@Override
	public List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo) {
		return agentBusinessDao.getAgentBusinessListByManageNo(mamageNo);
	}
	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return agentBusinessDao.updateTradeTotalById(id,tradeTotal);
	}

    @Override
    public List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition){
        return agentBusinessDao.getListForExcel(agentBusinessCondition);
    }
}