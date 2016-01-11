package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzfh.api.employee.service.ProbationEvaluationService;
import com.hzfh.service.employee.dao.ProbationEvaluationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("probationEvaluationService")
public class ProbationEvaluationServiceImpl extends BaseServiceImpl<ProbationEvaluation, ProbationEvaluationCondition, ProbationEvaluationDao> implements ProbationEvaluationService {
    @Autowired
    private ProbationEvaluationDao probationEvaluationDao;
	@Override
	public int updateActivitiStatusByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return probationEvaluationDao.updateActivitiStatusByActivitiNo(activitiNo);
	}
	@Override
	public ProbationEvaluation getInfoByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return probationEvaluationDao.getInfoByActivitiNo(activitiNo);
	}

	@Override
	public ProbationEvaluation getInfoByEmpNo(int empNo) {
		return probationEvaluationDao.getInfoByEmpNo(empNo);
	}
}