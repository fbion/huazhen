package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzframework.data.service.BaseService;

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


public interface EvaluationContentService extends BaseService<EvaluationContent, EvaluationContentCondition> {

	EvaluationContent getInfoByIdAndEvaluationRecordNo(int evaluationRecordNo,
			int evaluationContentNo);

	List<EvaluationContent> getListByTypeAndParentNo(byte type, int parentNo);
}