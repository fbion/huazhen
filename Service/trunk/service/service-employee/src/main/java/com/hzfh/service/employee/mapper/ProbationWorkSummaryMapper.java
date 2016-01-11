package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("probationWorkSummaryMapper")
public interface ProbationWorkSummaryMapper extends BaseMapper<ProbationWorkSummary, ProbationWorkSummaryCondition> {
    public ProbationWorkSummary getInfoByEmpNo(@Param("empNo")int empNo);

	public ProbationWorkSummary getInfoByActivitiNo(@Param("activitiNo")String activitiNo);
}