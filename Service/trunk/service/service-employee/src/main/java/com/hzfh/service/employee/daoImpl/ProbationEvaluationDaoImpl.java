package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzfh.service.employee.dao.ProbationEvaluationDao;
import com.hzfh.service.employee.mapper.ProbationEvaluationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("probationEvaluationDao")
public class ProbationEvaluationDaoImpl extends BaseDaoImpl<ProbationEvaluation, ProbationEvaluationCondition, ProbationEvaluationMapper> implements ProbationEvaluationDao {
	@Autowired
	private ProbationEvaluationMapper probationEvaluationMapper;
	@Override
	public int updateActivitiStatusByActivitiNo(String activitiNo) {
		return probationEvaluationMapper.updateActivitiStatusByActivitiNo(activitiNo);
	}
	@Override
	public ProbationEvaluation getInfoByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return probationEvaluationMapper.getInfoByActivitiNo(activitiNo);
	}

	@Override
	public ProbationEvaluation getInfoByEmpNo(int empNo) {
		return probationEvaluationMapper.getInfoByEmpNo(empNo);
	}
}