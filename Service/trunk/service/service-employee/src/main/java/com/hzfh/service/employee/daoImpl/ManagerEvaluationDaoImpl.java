package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzfh.service.employee.dao.ManagerEvaluationDao;
import com.hzfh.service.employee.mapper.ManagerEvaluationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("managerEvaluationDao")
public class ManagerEvaluationDaoImpl extends BaseDaoImpl<ManagerEvaluation, ManagerEvaluationCondition, ManagerEvaluationMapper> implements ManagerEvaluationDao {
	@Autowired
	private ManagerEvaluationMapper managerEvaluationMapper;
	@Override
	public int updateActivitiStatusByActivitiNo(String activitiNo) {
		return managerEvaluationMapper.updateActivitiStatusByActivitiNo(activitiNo);
	}
}