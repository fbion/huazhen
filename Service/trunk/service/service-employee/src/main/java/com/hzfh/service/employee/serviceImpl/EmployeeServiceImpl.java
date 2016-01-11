package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzfh.service.employee.dao.EmployeeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeCondition, EmployeeDao> implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public Employee getEmpByUserId(int userId) {
		return employeeDao.getEmpByUserId(userId);
	}

    public List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition) {
        return employeeDao.getInfoByCondition(employeeCondition);
    }
	@Override
	public List<Employee> getEmpListNoTest() {

        return employeeDao.getEmpListNoTest();
	}
    @Override
    public List<Employee> getEmpListByDept(int deptNo) {
        return employeeDao.getEmpListByDept(deptNo);
    }
	@Override
	public List<Employee> getEmpListByEmpId(int empId) {
		return employeeDao.getEmpListByEmpId(empId);
	}
	@Override
	public List<Employee> getEmpListByParentNo(int id) {
		return employeeDao.getEmpListByParentNo(id);
	}
	@Override
	public List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,
			int storeNo) {
		
		return employeeDao.getEmpByPositionNoAndStoreNo(positionNo,storeNo);
	}
	@Override
	public List<Employee> getEmpListByDeptAndStatus(int deptNo, String statusString) {
		return employeeDao.getEmpListByDeptAndStatus(deptNo, statusString);
	}
	@Override
	public int addFilePath(Employee employeeFile) {
		return employeeDao.addFilePath(employeeFile);
	}
	@Override
	public List<Employee> getEmpListByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return employeeDao.getEmpListByPositionNo(positionNo);
	}

	@Override
	public int updateEmpByEmpDetail(Employee employee) {
		return employeeDao.updateEmpByEmpDetail(employee);
	}
	@Override
	public Employee getEmpByEmpName(String byName) {
		return employeeDao.getEmpByEmpName(byName);
	}
	@Override
    public int updateIsSendEmailById(int id){
        return employeeDao.updateIsSendEmailById(id);
    }
	@Override
	public List<Employee> getNowEmpListByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return employeeDao.getNowEmpListByPositionNo(positionNo);
	}
	@Override
	public List<Employee> getEmpListByStatus(int status) {
		return employeeDao.getEmpListByStatus(status);
	}
	@Override
	public List<Employee> getEmpListIsTest(byte isTest) {
		return employeeDao.getEmpListIsTest(isTest);
	}

	@Override
	public int updateCheckById(int id,byte status) {
		return employeeDao.updateCheckById(id,status);
	}
	@Override
	public int updateStatusByEmpNo(int empNo) {
		return employeeDao.updateStatusByEmpNo(empNo);
	}
	@Override
	public List<Employee> getListForExcel(EmployeeCondition employeeCondition) {
		return employeeDao.getListForExcel(employeeCondition);
	}

	@Override
	public List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList) {
		return employeeDao.getEmpListByDeptAndStatusList(deptNo,statusList);
	}

	@Override
	public List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,
			int storeNo, int status) {
		return employeeDao.getEmpByPositionNoAndStoreNoIsUse(positionNo,storeNo,status);
	}
}