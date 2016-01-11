package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ProbationEvaluationScoreDao extends BaseDao<ProbationEvaluationScore, ProbationEvaluationScoreCondition> {

	List<ProbationEvaluationScore> getListByRecordNo(int recordNo);
}