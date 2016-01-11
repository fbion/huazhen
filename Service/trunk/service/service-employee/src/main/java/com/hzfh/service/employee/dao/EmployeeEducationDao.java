package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface EmployeeEducationDao extends BaseDao<EmployeeEducation, EmployeeEducationCondition> {
    List<EmployeeEducation> getEmpEduByEmpNo(int empNo);

}