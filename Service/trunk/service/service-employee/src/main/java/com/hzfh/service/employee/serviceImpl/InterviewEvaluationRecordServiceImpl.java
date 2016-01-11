package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.api.employee.service.InterviewEvaluationRecordService;
import com.hzfh.service.employee.dao.InterviewEvaluationRecordDao;
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


@Service("interviewEvaluationRecordService")
public class InterviewEvaluationRecordServiceImpl extends BaseServiceImpl<InterviewEvaluationRecord, InterviewEvaluationRecordCondition, InterviewEvaluationRecordDao> implements InterviewEvaluationRecordService {
    @Autowired
    private InterviewEvaluationRecordDao InterviewEvaluationRecordDao;
	@Override
	public List<InterviewEvaluationRecord> getInfoListByName(String name) {
		return InterviewEvaluationRecordDao.getInfoListByName(name);
	}
}