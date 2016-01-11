package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
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


@Service("agentBusinessMapper")
public interface AgentBusinessMapper extends BaseMapper<AgentBusiness, AgentBusinessCondition> {
    List<AgentBusiness> getMyAgentBusiness(@Param("workMateString")String workMateString);

	List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition);

	List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo);
	
	int updateTradeTotalById(@Param("id")int id,@Param("tradeTotal") double tradeTotal);

    List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition);
}