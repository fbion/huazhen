package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: huLei  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface WorkExperienceService extends BaseService<WorkExperience, WorkExperienceCondition> {
    List<WorkExperience> getWorkExperiencdByEmpNo(int empNo);

}