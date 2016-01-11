package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzfh.service.employee.dao.EmployeeCredentialDao;
import com.hzfh.service.employee.mapper.EmployeeCredentialMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("employeeCredentialDao")
public class EmployeeCredentialDaoImpl extends BaseDaoImpl<EmployeeCredential, EmployeeCredentialCondition, EmployeeCredentialMapper> implements EmployeeCredentialDao {
    @Autowired
    EmployeeCredentialMapper employeeCredentialMapper;
    @Override
    public List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo) {
        return employeeCredentialMapper.getEmpCredentialByEmpNo(empNo);
    }
}