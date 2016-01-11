package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzfh.api.sales.service.TaskDecisionService;
import com.hzfh.service.sales.dao.TaskDecisionDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("taskDecisionService")
public class TaskDecisionServiceImpl extends BaseServiceImpl<TaskDecision, TaskDecisionCondition, TaskDecisionDao> implements TaskDecisionService {
	@Autowired
	private TaskDecisionDao taskDecisionDao;

	@Override
	public List<TaskDecision> getListByProductTaskNo(int productTaskNo) {
		return taskDecisionDao.getListByProductTaskNo(productTaskNo);
	}
}