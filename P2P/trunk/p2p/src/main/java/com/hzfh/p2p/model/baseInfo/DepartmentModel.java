package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.p2p.facade.baseInfo.DepartmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DepartmentModel {
    
    public static List<Department> getListByDistrictNo(int districtNo) {
		return DepartmentFacade. getListByDistrictNo(districtNo);
	}
    public static PagedList<Department> getPagingList(
			DepartmentCondition departmentCondition) {
		return DepartmentFacade.getPagingList(departmentCondition);
	}
    public static Department getInfo(int id) {
		return DepartmentFacade.getInfo(id);
	}
}
