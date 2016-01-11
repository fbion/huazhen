package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzfh.api.employee.service.EmployeeDetailService;
import com.hzfh.service.employee.dao.EmployeeDetailDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("employeeDetailService")
public class EmployeeDetailServiceImpl extends BaseServiceImpl<EmployeeDetail, EmployeeDetailCondition, EmployeeDetailDao> implements EmployeeDetailService {
    @Autowired
    private EmployeeDetailDao employeeDetailDao;

    @Override
    public EmployeeDetail getEmpDetailByEmpNo(int empNo) {
        return employeeDetailDao.getEmpDetailByEmpNo(empNo);
    }

    @Override
    public int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail) {
        return employeeDetailDao.updateEmpDetailByEmpNo(employeeDetail);
    }

    @Override
    public int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo) {
        return employeeDetailDao.updateEmpDetailByOtherInfo(empDetailInfo);
    }
}