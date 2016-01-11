package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ProbationEvaluationDao extends BaseDao<ProbationEvaluation, ProbationEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(String activitiNo);

	ProbationEvaluation getInfoByActivitiNo(String activitiNo);

	ProbationEvaluation getInfoByEmpNo(int empNo);
}