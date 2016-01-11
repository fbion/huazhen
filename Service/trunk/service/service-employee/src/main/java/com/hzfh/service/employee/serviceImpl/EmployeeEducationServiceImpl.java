package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzfh.api.employee.service.EmployeeEducationService;
import com.hzfh.service.employee.dao.EmployeeEducationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("employeeEducationService")
public class EmployeeEducationServiceImpl extends BaseServiceImpl<EmployeeEducation, EmployeeEducationCondition, EmployeeEducationDao> implements EmployeeEducationService {
    @Autowired
    private EmployeeEducationDao employeeEducationDao;

    @Override
    public List<EmployeeEducation> getEmpEduByEmpNo(int empNo) {
        return employeeEducationDao.getEmpEduByEmpNo(empNo);
    }

}