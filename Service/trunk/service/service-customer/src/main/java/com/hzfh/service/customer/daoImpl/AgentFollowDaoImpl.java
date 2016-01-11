package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.AgentFollow;
import com.hzfh.api.customer.model.query.AgentFollowCondition;
import com.hzfh.service.customer.dao.AgentFollowDao;
import com.hzfh.service.customer.mapper.AgentFollowMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("agentFollowDao")
public class AgentFollowDaoImpl extends BaseDaoImpl<AgentFollow, AgentFollowCondition, AgentFollowMapper> implements AgentFollowDao {
}