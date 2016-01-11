package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.api.employee.service.DepartmentService;
import com.hzfh.service.employee.dao.DepartmentDao;
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


@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentCondition, DepartmentDao> implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public List<Department> getDeptlist() {
		return departmentDao.getDeptlist();
	}
	@Override
	public Department getDeptByDeptId(int deptId) {
		return departmentDao.getDeptByDeptId(deptId);
	}
	@Override
	public List<Department> getDeptListByParentNo(int parentNo) {
		return departmentDao.getDeptListByParentNo(parentNo);
	}
	@Override
	public List<Department> getDeptListByCompanyNo(int companyNo) {
		return departmentDao.getDeptListByCompanyNo(companyNo);
	}
	@Override
	public List<Department> getDeptListByType(int deptType) {
		
		return departmentDao.getDeptListByType(deptType);
	}
	@Override
	public List<Department> getListByDistrictNo(int districtNo) {
		return departmentDao.getListByDistrictNo(districtNo);
	}
	@Override
	public int getParentDeptByDept(int deptNo) {
		return departmentDao.getParentDeptByDept(deptNo);
	}
	@Override
	public List<Department> getDeptTypeBydeptNo(int deptNo) {
		return departmentDao.getDeptTypeBydeptNo(deptNo);
	}
	@Override
	public Department getDepartmentByDeptNo(int deptNo) {
		return departmentDao.getDepartmentByDeptNo(deptNo);
	}
	@Override
	public List<Department> getDeptListByTypeaAndStatus(int deptType, int status) {
		return departmentDao.getDeptListByTypeaAndStatus(deptType,status);
	}
	

}