package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("employeeCredentialMapper")
public interface EmployeeCredentialMapper extends BaseMapper<EmployeeCredential, EmployeeCredentialCondition> {
    List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo);
}