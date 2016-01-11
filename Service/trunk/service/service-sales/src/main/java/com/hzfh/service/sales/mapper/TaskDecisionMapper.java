package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("taskDecisionMapper")
public interface TaskDecisionMapper extends BaseMapper<TaskDecision, TaskDecisionCondition> {
	public List<TaskDecision> getListByProductTaskNo(int productTaskNo);

}