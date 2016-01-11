package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.weixin.facade.baseInfo.DepartmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DepartmentModel {
    
    public static List<Department> getListByDistrictNo(int districtNo) {
		return DepartmentFacade. getListByDistrictNo(districtNo);
	}
    public static Department getInfo(int id) {
		return DepartmentFacade.getInfo(id);
	}
    public static PagedList<Department> getPagingList(DepartmentCondition departmentCondition) {
		return DepartmentFacade.getPagingList(departmentCondition);
	}
	public static List<Department> getDeptListByTypeaAndStatus(int deptType,int status) {
		return DepartmentFacade.getDeptListByTypeaAndStatus(deptType,status);
	}
}
