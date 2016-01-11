package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzfh.api.employee.service.EvaluationContentService;
import com.hzfh.service.employee.dao.EvaluationContentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("evaluationContentService")
public class EvaluationContentServiceImpl extends BaseServiceImpl<EvaluationContent, EvaluationContentCondition, EvaluationContentDao> implements EvaluationContentService {
    @Autowired
    private EvaluationContentDao evaluationContentDao;
	@Override
	public EvaluationContent getInfoByIdAndEvaluationRecordNo(
			int evaluationRecordNo, int evaluationContentNo) {
		
		return evaluationContentDao.getInfoByIdAndEvaluationRecordNo(
				evaluationRecordNo, evaluationContentNo);
	}
	@Override
	public List<EvaluationContent> getListByTypeAndParentNo(byte type,
			int parentNo) {
		return evaluationContentDao.getListByTypeAndParentNo(type, parentNo);
	}
}