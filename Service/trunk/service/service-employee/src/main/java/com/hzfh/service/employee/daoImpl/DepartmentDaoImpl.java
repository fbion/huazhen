package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.service.employee.dao.DepartmentDao;
import com.hzfh.service.employee.mapper.DepartmentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department, DepartmentCondition, DepartmentMapper> implements DepartmentDao {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> getDeptlist() {
		return departmentMapper.getDeptlist();
	}
	@Override
	public Department getDeptByDeptId(int deptId) {
		return departmentMapper.getDeptByDeptId(deptId);
	}
	@Override
	public List<Department> getDeptListByParentNo(int parentNo) {
		return departmentMapper.getDeptListByParentNo(parentNo);
	}
	@Override
	public List<Department> getDeptListByCompanyNo(int companyNo) {
		return departmentMapper.getDeptListByCompanyNo(companyNo);
	}
	@Override
	public List<Department> getDeptListByType(int deptType) {
		
		return departmentMapper.getDeptListByType(deptType); 
	}
	@Override
	public List<Department> getListByDistrictNo(int districtNo) {
		
		return departmentMapper.getListByDistrictNo(districtNo);
	}
	@Override
	public int getParentDeptByDept(int deptNo) {
		return departmentMapper.getParentDeptByDept(deptNo);
	}
	@Override
	public List<Department> getDeptTypeBydeptNo(int deptNo) {
		return departmentMapper.getDeptTypeBydeptNo(deptNo);
	}
	@Override
	public Department getDepartmentByDeptNo(int deptNo) {
		return departmentMapper.getDepartmentByDeptNo(deptNo);
	}
	@Override
	public List<Department> getDeptListByTypeaAndStatus(int deptType, int status) {
		return departmentMapper.getDeptListByTypeaAndStatus(deptType,status);
	}

}