package com.hzfh.service.workFlow.facade.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static int add(Employee employee) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.add(employee);
    }

    public static int update(Employee employee) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.update(employee);
    }

    public static List<Employee> getList() {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getList();
    }

    public static Employee getInfo(int id) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getInfo(id);
    }

    public static Employee getEmpByUserId(int id) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        return employeeService.getEmpByUserId(id);
    }

    public static List<Employee> getEmpListByDept(int deptNo) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        return employeeService.getEmpListByDept(deptNo);
    }

    public static List<Employee> getEmpListByParentNo(int id) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        return employeeService.getEmpListByParentNo(id);
    }

    public static List<Employee> getEmpListByPositionNo(int positionNo) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        return employeeService.getEmpListByPositionNo(positionNo);
    }

}
