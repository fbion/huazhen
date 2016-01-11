package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface EmployeeCredentialDao extends BaseDao<EmployeeCredential, EmployeeCredentialCondition> {
    List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo);
}