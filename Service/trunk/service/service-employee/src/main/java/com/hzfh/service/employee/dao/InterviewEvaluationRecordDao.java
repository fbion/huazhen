package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface InterviewEvaluationRecordDao extends BaseDao<InterviewEvaluationRecord, InterviewEvaluationRecordCondition> {

	List<InterviewEvaluationRecord> getInfoListByName(String name);
}