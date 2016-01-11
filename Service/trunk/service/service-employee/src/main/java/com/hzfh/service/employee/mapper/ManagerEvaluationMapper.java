package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("managerEvaluationMapper")
public interface ManagerEvaluationMapper extends BaseMapper<ManagerEvaluation, ManagerEvaluationCondition> {

	int updateActivitiStatusByActivitiNo(@Param("activitiNo")String activitiNo);
}