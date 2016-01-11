package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.weixin.facade.baseInfo.EmployeeFacade;

import java.util.List;

public class EmployeeModel {
    
    public static List<Employee> getListByDepartmentNo(int departmentNo) {
		return EmployeeFacade.getEmpListByDept(departmentNo);
	}
    
    public static List<Employee> getEmpListByDeptAndStatus(int deptNo,String status) {
    	return EmployeeFacade.getEmpListByDeptAndStatus(deptNo, status);
    }
    public static Employee getInfo(int id) {
        return EmployeeFacade.getInfo(id);
    }

	public static Employee getEmpByUserId(int userId) {
		return EmployeeFacade.getEmpByUserId(userId);
	}
	public static List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList) {
		return EmployeeFacade.getEmpListByDeptAndStatusList(deptNo, statusList);
	}
}
