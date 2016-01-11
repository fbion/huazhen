package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzfh.service.sales.dao.TaskDecisionLogDao;
import com.hzfh.service.sales.mapper.TaskDecisionLogMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/26 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("taskDecisionLogDao")
public class TaskDecisionLogDaoImpl extends BaseDaoImpl<TaskDecisionLog, TaskDecisionLogCondition, TaskDecisionLogMapper> implements TaskDecisionLogDao {
}