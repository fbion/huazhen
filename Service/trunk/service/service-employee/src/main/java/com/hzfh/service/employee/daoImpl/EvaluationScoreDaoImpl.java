package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.query.EvaluationScoreCondition;
import com.hzfh.service.employee.dao.EvaluationScoreDao;
import com.hzfh.service.employee.mapper.EvaluationScoreMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("evaluationScoreDao")
public class EvaluationScoreDaoImpl extends BaseDaoImpl<EvaluationScore, EvaluationScoreCondition, EvaluationScoreMapper> implements EvaluationScoreDao {

	@Autowired
	private EvaluationScoreMapper evaluationScoreMapper;
	@Override
	public List<EvaluationScore> getListByEvaluationRecordNo(int id) {
		return evaluationScoreMapper.getListByEvaluationRecordNo(id);
	}
}