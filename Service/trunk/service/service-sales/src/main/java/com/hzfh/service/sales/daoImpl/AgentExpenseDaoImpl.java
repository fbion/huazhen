package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.AgentExpense;
import com.hzfh.api.sales.model.query.AgentExpenseCondition;
import com.hzfh.service.sales.dao.AgentExpenseDao;
import com.hzfh.service.sales.mapper.AgentExpenseMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("agentExpenseDao")
public class AgentExpenseDaoImpl extends BaseDaoImpl<AgentExpense, AgentExpenseCondition, AgentExpenseMapper> implements AgentExpenseDao {
}