package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
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


public interface DepartmentDao extends BaseDao<Department, DepartmentCondition> {
	public List<Department> getDeptlist();

	public Department getDeptByDeptId(int deptId);

	public List<Department> getDeptListByParentNo(int parentNo);

	public List<Department> getDeptListByCompanyNo(int companyNo);
	public List<Department> getDeptListByType(int deptType);

	public List<Department> getListByDistrictNo(int districtNo);

	public int getParentDeptByDept(int deptNo);

	public List<Department> getDeptTypeBydeptNo(int deptNo);

	public Department getDepartmentByDeptNo(int deptNo);

	public List<Department> getDeptListByTypeaAndStatus(int deptType, int status);
	
}