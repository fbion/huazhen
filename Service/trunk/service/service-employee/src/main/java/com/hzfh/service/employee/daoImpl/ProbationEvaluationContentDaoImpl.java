package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ProbationEvaluationContent;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentCondition;
import com.hzfh.service.employee.dao.ProbationEvaluationContentDao;
import com.hzfh.service.employee.mapper.ProbationEvaluationContentMapper;
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


@Service("probationEvaluationContentDao")
public class ProbationEvaluationContentDaoImpl extends BaseDaoImpl<ProbationEvaluationContent, ProbationEvaluationContentCondition, ProbationEvaluationContentMapper> implements ProbationEvaluationContentDao {

	@Autowired 
	private ProbationEvaluationContentMapper probationEvaluationContentMapper;
	@Override
	public List<ProbationEvaluationContent> getListByRecordNo(int id) {
		return probationEvaluationContentMapper.getListByRecordNo(id);
	}
}