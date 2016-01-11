package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzfh.service.sales.dao.TaskDecisionDao;
import com.hzfh.service.sales.mapper.TaskDecisionMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("taskDecisionDao")
public class TaskDecisionDaoImpl extends BaseDaoImpl<TaskDecision, TaskDecisionCondition, TaskDecisionMapper> implements TaskDecisionDao {
	@Autowired
	private TaskDecisionMapper TaskDecisionMapper;

	@Override
	public List<TaskDecision> getListByProductTaskNo(int productTaskNo) {
		return TaskDecisionMapper.getListByProductTaskNo(productTaskNo);
	}
	
}