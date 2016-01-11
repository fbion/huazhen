package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("probationEvaluationMapper")
public interface ProbationEvaluationMapper extends BaseMapper<ProbationEvaluation, ProbationEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(@Param("activitiNo")String activitiNo);

	ProbationEvaluation getInfoByActivitiNo(@Param("activitiNo")String activitiNo);

	ProbationEvaluation getInfoByEmpNo(int empNo);
}