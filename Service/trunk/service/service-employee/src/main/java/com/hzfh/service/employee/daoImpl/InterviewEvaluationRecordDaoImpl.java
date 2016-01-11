package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.service.employee.dao.InterviewEvaluationRecordDao;
import com.hzfh.service.employee.mapper.InterviewEvaluationRecordMapper;
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


@Service("interviewEvaluationRecordDao")
public class InterviewEvaluationRecordDaoImpl extends BaseDaoImpl<InterviewEvaluationRecord, InterviewEvaluationRecordCondition, InterviewEvaluationRecordMapper> implements InterviewEvaluationRecordDao {

	@Autowired
	private InterviewEvaluationRecordMapper interviewEvaluationRecordMapper;
	@Override
	public List<InterviewEvaluationRecord> getInfoListByName(String name) {
		return interviewEvaluationRecordMapper.getInfoListByName(name);
	}
}