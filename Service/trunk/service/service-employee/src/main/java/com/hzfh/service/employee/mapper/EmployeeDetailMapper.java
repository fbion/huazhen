package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("employeeDetailMapper")
public interface EmployeeDetailMapper extends BaseMapper<EmployeeDetail, EmployeeDetailCondition> {
    EmployeeDetail getEmpDetailByEmpNo(int empNo);
    int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail);
    int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo);


}