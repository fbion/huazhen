package com.hzfh.service.employee.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.service.employee.dao.EmployeeDao;
import com.hzfh.service.employee.mapper.EmployeeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee, EmployeeCondition, EmployeeMapper> implements EmployeeDao {
	@Autowired
	private EmployeeMapper employeeMapper;
	@Override
	public Employee getEmpByUserId(int userId) {
		return employeeMapper.getEmpByUserId(userId);
	}
	@Override
	public List<Employee> getEmpListByDept(int deptNo) {
		return employeeMapper.getEmpListByDept(deptNo);
	}
	@Override
	public List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition) {
		return employeeMapper.getInfoByCondition(employeeCondition);
	}

    @Override
    public List<Employee> getEmpListByEmpId(int empId) {
        return employeeMapper.getEmpListByEmpId(empId);
    }
    @Override
    public List<Employee> getEmpListNoTest() {

        return employeeMapper.getEmpListNoTest();
    }

	@Override
	public List<Employee> getEmpListByParentNo(int id) {
		return employeeMapper.getEmpListByParentNo(id);
	}
	@Override
	public List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,
			int storeNo) {
		
		return employeeMapper.getEmpByPositionNoAndStoreNo(positionNo,storeNo);
	}
	@Override
	public List<Employee> getEmpListByDeptAndStatus(int deptNo, String statusString) {//新添 liyh
		return employeeMapper.getEmpListByDeptAndStatus(deptNo, statusString);
	}
	@Override
	public int addFilePath(Employee employeeFile) {
		return employeeMapper.addFilePath(employeeFile);
	}
	@Override
	public List<Employee> getEmpListByPositionNo(int positionNo) {
		return employeeMapper.getEmpListByPositionNo(positionNo);
	}

	@Override
	public int updateEmpByEmpDetail(Employee employee) {
		return employeeMapper.updateEmpByEmpDetail(employee);
	}
	@Override
	public Employee getEmpByEmpName(String byName) {
		return employeeMapper.getEmpByEmpName(byName);
	}

    @Override
    public int updateIsSendEmailById(int id){
        return employeeMapper.updateIsSendEmailById(id);
    }
	@Override
	public List<Employee> getNowEmpListByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return employeeMapper.getNowEmpListByPositionNo(positionNo);
	}
	@Override
	public List<Employee> getEmpListByStatus(int status) {
		return employeeMapper.getEmpListByStatus(status);
	}
	@Override
	public List<Employee> getEmpListIsTest(byte isTest) {
		return employeeMapper.getEmpListIsTest(isTest);
	}

	@Override
	public int updateCheckById(int id,byte status) {
		return employeeMapper.updateCheckById(id,status);
	}
	@Override
	public int updateStatusByEmpNo(int empNo) {
		return employeeMapper.updateStatusByEmpNo(empNo);
	}
	@Override
	public List<Employee> getListForExcel(EmployeeCondition employeeCondition) {
		return employeeMapper.getListForExcel(employeeCondition);
	}
	@Override
	public List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList) {
		return employeeMapper.getEmpListByDeptAndStatusList(deptNo,statusList);
	}
	@Override
	public List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,
			int storeNo, int status) {
		return employeeMapper.getEmpByPositionNoAndStoreNoIsUse(positionNo,storeNo,status);
	}
}