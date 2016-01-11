package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzfh.service.employee.dao.EvaluationContentDao;
import com.hzfh.service.employee.mapper.EvaluationContentMapper;
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


@Service("evaluationContentDao")
public class EvaluationContentDaoImpl extends BaseDaoImpl<EvaluationContent, EvaluationContentCondition, EvaluationContentMapper> implements EvaluationContentDao {
	@Autowired
    private EvaluationContentMapper evaluationContentMapper;
	@Override
	public EvaluationContent getInfoByIdAndEvaluationRecordNo(
			int evaluationRecordNo, int evaluationContentNo) {
		return evaluationContentMapper.getInfoByIdAndEvaluationRecordNo(
				evaluationRecordNo, evaluationContentNo);
	}
	@Override
	public List<EvaluationContent> getListByTypeAndParentNo(byte type,
			int parentNo) {
		return evaluationContentMapper.getListByTypeAndParentNo(type,
				parentNo);
	}
}