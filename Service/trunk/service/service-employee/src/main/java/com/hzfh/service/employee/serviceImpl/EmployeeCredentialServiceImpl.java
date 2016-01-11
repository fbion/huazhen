package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzfh.api.employee.service.EmployeeCredentialService;
import com.hzfh.service.employee.dao.EmployeeCredentialDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("employeeCredentialService")
public class EmployeeCredentialServiceImpl extends BaseServiceImpl<EmployeeCredential, EmployeeCredentialCondition, EmployeeCredentialDao> implements EmployeeCredentialService {
    @Autowired
    EmployeeCredentialDao employeeCredentialDao;
    @Override
    public List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo) {
        return employeeCredentialDao.getEmpCredentialByEmpNo(empNo);
    }
}