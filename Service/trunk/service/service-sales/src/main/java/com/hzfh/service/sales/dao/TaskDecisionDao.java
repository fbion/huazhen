package com.hzfh.service.sales.dao;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface TaskDecisionDao extends BaseDao<TaskDecision, TaskDecisionCondition> {

	List<TaskDecision> getListByProductTaskNo(int productTaskNo);
	
}