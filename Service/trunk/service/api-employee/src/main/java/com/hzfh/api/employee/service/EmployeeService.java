package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzframework.data.service.BaseService;

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


public interface EmployeeService extends BaseService<Employee, EmployeeCondition> {

	List<Employee> getEmpListByDept(int deptNo);
	
	public List<Employee> getEmpListByDeptAndStatus(int deptNo,String statusString);

	List<Employee> getEmpListByEmpId(int empId);

	Employee getEmpByUserId(int id);

    List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition);

	List<Employee> getEmpListByParentNo(int id);
	List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,int storeNo);
	
	List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,int storeNo,int status);

	int addFilePath(Employee employeeFile);

	List<Employee> getEmpListByPositionNo(int positionNo);

	int updateEmpByEmpDetail(Employee employee);

	Employee getEmpByEmpName(String byName);

    int updateIsSendEmailById(int id);

	List<Employee> getNowEmpListByPositionNo(int positionNo);

	List<Employee> getEmpListByStatus(int status);
    List<Employee> getEmpListNoTest();

	List<Employee> getEmpListIsTest(byte isTest);

	int updateCheckById(int id,byte status);

	int updateStatusByEmpNo(int empNo);

	List<Employee> getListForExcel(EmployeeCondition employeeCondition);

	List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList);

}