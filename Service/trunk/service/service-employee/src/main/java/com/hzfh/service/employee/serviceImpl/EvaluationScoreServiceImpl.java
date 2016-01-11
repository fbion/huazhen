package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.query.EvaluationScoreCondition;
import com.hzfh.api.employee.service.EvaluationScoreService;
import com.hzfh.service.employee.dao.EvaluationScoreDao;
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


@Service("evaluationScoreService")
public class EvaluationScoreServiceImpl extends BaseServiceImpl<EvaluationScore, EvaluationScoreCondition, EvaluationScoreDao> implements EvaluationScoreService {
    @Autowired
    private EvaluationScoreDao evaluationScoreDao;
	@Override
	public List<EvaluationScore> getListByEvaluationRecordNo(int id) {
		return evaluationScoreDao.getListByEvaluationRecordNo(id);
	}
}