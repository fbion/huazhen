package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface EvaluationContentDao extends BaseDao<EvaluationContent, EvaluationContentCondition> {

	EvaluationContent getInfoByIdAndEvaluationRecordNo(int evaluationRecordNo,
			int evaluationContentNo);

	List<EvaluationContent> getListByTypeAndParentNo(byte type, int parentNo);
}