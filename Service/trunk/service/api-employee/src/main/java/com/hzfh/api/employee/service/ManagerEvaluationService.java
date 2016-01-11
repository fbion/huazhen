package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzframework.data.service.BaseService;

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


public interface ManagerEvaluationService extends BaseService<ManagerEvaluation, ManagerEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(String activitiNo);
}