package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzfh.service.employee.dao.ProbationEvaluationScoreDao;
import com.hzfh.service.employee.mapper.ProbationEvaluationScoreMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("probationEvaluationScoreDao")
public class ProbationEvaluationScoreDaoImpl extends BaseDaoImpl<ProbationEvaluationScore, ProbationEvaluationScoreCondition, ProbationEvaluationScoreMapper> implements ProbationEvaluationScoreDao {

	@Autowired
	private ProbationEvaluationScoreMapper probationEvaluationScoreMapper;
	@Override
	public List<ProbationEvaluationScore> getListByRecordNo(int recordNo) {
		return probationEvaluationScoreMapper.getListByRecordNo(recordNo);
	}
}