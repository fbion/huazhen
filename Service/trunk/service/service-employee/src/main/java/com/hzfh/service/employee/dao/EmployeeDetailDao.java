package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface EmployeeDetailDao extends BaseDao<EmployeeDetail, EmployeeDetailCondition> {
    EmployeeDetail getEmpDetailByEmpNo(int empNo);
    int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail);
    int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo);
}