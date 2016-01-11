package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface EmployeeDao extends BaseDao<Employee, EmployeeCondition> {
	public Employee getEmpByUserId(int userId);
	public List<Employee> getEmpListByDept(int deptNo);
	public List<Employee> getEmpListByDeptAndStatus(int deptNo,String statusString);//新添
	public List<Employee> getEmpListByEmpId(int empId);
    public List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition);
	public List<Employee> getEmpListByParentNo(int id);
	public List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,int storeNo);
	public List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,int storeNo,int status);
	public int addFilePath(Employee employeeFile);
	public List<Employee> getEmpListByPositionNo(int positionNo);
	int updateEmpByEmpDetail(Employee employee);
	public Employee getEmpByEmpName(String byName);

    public int updateIsSendEmailById(int id);
	public List<Employee> getNowEmpListByPositionNo(int positionNo);
	public List<Employee> getEmpListByStatus(int status);
    public List<Employee> getEmpListNoTest();
	public List<Employee> getEmpListIsTest(byte isTest);

	int updateCheckById(int id,byte status);
	public int updateStatusByEmpNo(int empNo);
	public List<Employee> getListForExcel(EmployeeCondition employeeCondition);
	public List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList);
}