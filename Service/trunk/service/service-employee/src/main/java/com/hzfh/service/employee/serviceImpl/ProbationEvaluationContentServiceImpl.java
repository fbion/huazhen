package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ProbationEvaluationContent;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentCondition;
import com.hzfh.api.employee.service.ProbationEvaluationContentService;
import com.hzfh.service.employee.dao.ProbationEvaluationContentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("probationEvaluationContentService")
public class ProbationEvaluationContentServiceImpl extends BaseServiceImpl<ProbationEvaluationContent, ProbationEvaluationContentCondition, ProbationEvaluationContentDao> implements ProbationEvaluationContentService {

	@Autowired
	private ProbationEvaluationContentDao probationEvaluationContentDao;
	@Override
	public List<ProbationEvaluationContent> getListByRecordNo(int id) {
		return probationEvaluationContentDao.getListByRecordNo(id);
	}
}