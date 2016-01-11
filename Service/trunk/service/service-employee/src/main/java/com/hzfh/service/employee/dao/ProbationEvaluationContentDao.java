package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.ProbationEvaluationContent;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentCondition;
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


public interface ProbationEvaluationContentDao extends BaseDao<ProbationEvaluationContent, ProbationEvaluationContentCondition> {

	List<ProbationEvaluationContent> getListByRecordNo(int id);
}