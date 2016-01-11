package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("taskDecisionLogMapper")
public interface TaskDecisionLogMapper extends BaseMapper<TaskDecisionLog, TaskDecisionLogCondition> {
}