package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("employeeEducationMapper")
public interface EmployeeEducationMapper extends BaseMapper<EmployeeEducation, EmployeeEducationCondition> {

    List<EmployeeEducation> getEmpEduByEmpNo(int empNo);

}