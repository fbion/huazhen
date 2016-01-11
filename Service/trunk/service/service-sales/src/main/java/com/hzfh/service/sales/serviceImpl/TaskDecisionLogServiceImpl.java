package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzfh.api.sales.service.TaskDecisionLogService;
import com.hzfh.service.sales.dao.TaskDecisionLogDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("taskDecisionLogService")
public class TaskDecisionLogServiceImpl extends BaseServiceImpl<TaskDecisionLog, TaskDecisionLogCondition, TaskDecisionLogDao> implements TaskDecisionLogService {
}