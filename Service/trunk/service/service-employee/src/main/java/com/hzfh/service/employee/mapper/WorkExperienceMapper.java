package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("workExperienceMapper")
public interface WorkExperienceMapper extends BaseMapper<WorkExperience, WorkExperienceCondition> {
    List<WorkExperience> getWorkExperiencdByEmpNo(int empNo);

}