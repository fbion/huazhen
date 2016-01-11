package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

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


public interface ProbationEvaluationScoreService extends BaseService<ProbationEvaluationScore, ProbationEvaluationScoreCondition> {

	List<ProbationEvaluationScore> getListByRecordNo(int recordNo);
}