package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzframework.data.service.BaseService;

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


public interface ProbationEvaluationService extends BaseService<ProbationEvaluation, ProbationEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(String activitiNo);

	ProbationEvaluation getInfoByActivitiNo(String activitiNo);

	ProbationEvaluation getInfoByEmpNo(int empNo);
}