package com.hzfh.weixin.facade.baseInfo;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.service.EmployeeService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");
	public static List<Employee> getEmpListByDept(int deptNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByDept(deptNo);
	}
	public static List<Employee> getEmpListByDeptAndStatus(int deptNo,String statusString) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByDeptAndStatus(deptNo, statusString);
	}
	public static Employee getInfo(int id) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getInfo(id);
	}
	public static Employee getEmpByUserId(int userId) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpByUserId(userId);
	}
	public static List<Employee> getEmpListByDeptAndStatusList(int deptNo,List<Integer> statusList) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByDeptAndStatusList(deptNo,statusList);
	}
}
