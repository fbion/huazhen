package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzfh.service.employee.dao.EmployeeDetailDao;
import com.hzfh.service.employee.mapper.EmployeeDetailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("employeeDetailDao")
public class EmployeeDetailDaoImpl extends BaseDaoImpl<EmployeeDetail, EmployeeDetailCondition, EmployeeDetailMapper> implements EmployeeDetailDao {
    @Autowired
    private EmployeeDetailMapper employeeDetailMapper;

    @Override
    public EmployeeDetail getEmpDetailByEmpNo(int empNo) {
        return employeeDetailMapper.getEmpDetailByEmpNo(empNo);
    }

    @Override
    public int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail) {
        return employeeDetailMapper.updateEmpDetailByEmpNo(employeeDetail);
    }

    @Override
    public int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo) {
        return employeeDetailMapper.updateEmpDetailByOtherInfo(empDetailInfo);
    }
}