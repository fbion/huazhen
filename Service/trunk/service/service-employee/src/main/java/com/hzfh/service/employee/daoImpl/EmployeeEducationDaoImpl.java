package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzfh.service.employee.dao.EmployeeEducationDao;
import com.hzfh.service.employee.mapper.EmployeeEducationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("employeeEducationDao")
public class EmployeeEducationDaoImpl extends BaseDaoImpl<EmployeeEducation, EmployeeEducationCondition, EmployeeEducationMapper> implements EmployeeEducationDao {
    @Autowired
    private EmployeeEducationMapper employeeEducationMapper;

    @Override
    public List<EmployeeEducation> getEmpEduByEmpNo(int empNo) {
        return employeeEducationMapper.getEmpEduByEmpNo(empNo);
    }

}