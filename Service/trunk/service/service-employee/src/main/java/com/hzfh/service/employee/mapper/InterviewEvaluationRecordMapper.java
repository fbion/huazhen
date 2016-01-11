package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("interviewEvaluationRecordMapper")
public interface InterviewEvaluationRecordMapper extends BaseMapper<InterviewEvaluationRecord, InterviewEvaluationRecordCondition> {

	List<InterviewEvaluationRecord> getInfoListByName(@Param("name")String name);
}