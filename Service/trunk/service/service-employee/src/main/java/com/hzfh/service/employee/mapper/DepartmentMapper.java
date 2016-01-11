package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("departmentMapper")
public interface DepartmentMapper extends BaseMapper<Department, DepartmentCondition> {
	public List<Department> getDeptlist();

	public Department getDeptByDeptId(int deptId);

	public List<Department> getDeptListByParentNo(int parentNo);

	public List<Department> getDeptListByCompanyNo(int companyNo);
	
	public List<Department> getDeptListByType(int deptType);
	
	public List<Department> getListByDistrictNo(int districtNo);
	
	public int getParentDeptByDept(int deptNo);

	public List<Department> getDeptTypeBydeptNo(int deptNo);

	public Department getDepartmentByDeptNo(int deptNo);

	public List<Department> getDeptListByTypeaAndStatus(@Param("deptType")int deptType, @Param("status")int status);
	
}