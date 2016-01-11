package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: HuLei  
 * Create Date: 2015/5/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface EmployeeEducationService extends BaseService<EmployeeEducation, EmployeeEducationCondition> {
    List<EmployeeEducation> getEmpEduByEmpNo(int empNo);

}