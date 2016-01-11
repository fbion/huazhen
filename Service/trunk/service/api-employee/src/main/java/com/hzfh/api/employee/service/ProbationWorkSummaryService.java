package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzframework.data.service.BaseService;

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


public interface ProbationWorkSummaryService extends BaseService<ProbationWorkSummary, ProbationWorkSummaryCondition> {
    ProbationWorkSummary getInfoByEmpNo(int empNo);

	ProbationWorkSummary getInfoByActivitiNo(String activitiNo);

}