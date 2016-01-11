package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzfh.api.employee.service.ManagerEvaluationService;
import com.hzfh.service.employee.dao.ManagerEvaluationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("managerEvaluationService")
public class ManagerEvaluationServiceImpl extends BaseServiceImpl<ManagerEvaluation, ManagerEvaluationCondition, ManagerEvaluationDao> implements ManagerEvaluationService {
	@Autowired
	private ManagerEvaluationDao managerEvaluationDao;
	@Override
	public int updateActivitiStatusByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return managerEvaluationDao.updateActivitiStatusByActivitiNo(activitiNo);
	}
}