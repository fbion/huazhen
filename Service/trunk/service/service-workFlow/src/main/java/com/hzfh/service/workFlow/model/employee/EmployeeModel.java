package com.hzfh.service.workFlow.model.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.service.workFlow.facade.employee.EmployeeFacade;

import java.util.List;

public class EmployeeModel {
    public static int add(Employee employee) {
        return EmployeeFacade.add(employee);
    }

    public static int update(Employee employee) {
        return EmployeeFacade.update(employee);
    }

    public static List<Employee> getList() {
        return EmployeeFacade.getList();
    }

    public static Employee getInfo(int id) {
        return EmployeeFacade.getInfo(id);
    }

    public static Employee getEmpByUserId(int userId) {
        return EmployeeFacade.getEmpByUserId(userId);
    }

    public static List<Employee> getEmpListByDept(int deptNo) {
        return EmployeeFacade.getEmpListByDept(deptNo);
    }

    public static List<Employee> getEmpListByParentNo(int id) {
        return EmployeeFacade.getEmpListByParentNo(id);
    }

    public static List<Employee> getEmpListByPositionNo(int positionNo) {
        return EmployeeFacade.getEmpListByPositionNo(positionNo);
    }

}
