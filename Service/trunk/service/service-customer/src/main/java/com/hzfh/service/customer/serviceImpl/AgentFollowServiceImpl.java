package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.AgentFollow;
import com.hzfh.api.customer.model.query.AgentFollowCondition;
import com.hzfh.api.customer.service.AgentFollowService;
import com.hzfh.service.customer.dao.AgentFollowDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("agentFollowService")
public class AgentFollowServiceImpl extends BaseServiceImpl<AgentFollow, AgentFollowCondition, AgentFollowDao> implements AgentFollowService {
}