package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ManagerEvaluationDao extends BaseDao<ManagerEvaluation, ManagerEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(String activitiNo);
}