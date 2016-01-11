package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.AgentExpense;
import com.hzfh.api.sales.model.query.AgentExpenseCondition;
import com.hzfh.api.sales.service.AgentExpenseService;
import com.hzfh.service.sales.dao.AgentExpenseDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

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


@Service("agentExpenseService")
public class AgentExpenseServiceImpl extends BaseServiceImpl<AgentExpense, AgentExpenseCondition, AgentExpenseDao> implements AgentExpenseService {
}