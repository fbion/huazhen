package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzfh.api.employee.service.ProbationEvaluationScoreService;
import com.hzfh.service.employee.dao.ProbationEvaluationScoreDao;
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


@Service("probationEvaluationScoreService")
public class ProbationEvaluationScoreServiceImpl extends BaseServiceImpl<ProbationEvaluationScore, ProbationEvaluationScoreCondition, ProbationEvaluationScoreDao> implements ProbationEvaluationScoreService {

	@Autowired
	private ProbationEvaluationScoreDao probationEvaluationScoreDao;
	@Override
	public List<ProbationEvaluationScore> getListByRecordNo(int recordNo) {
		return probationEvaluationScoreDao.getListByRecordNo(recordNo);
	}
}