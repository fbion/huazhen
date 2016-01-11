package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzfh.api.employee.service.EmployeeEducationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeEducationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EmployeeEducation> getPagingList(EmployeeEducationCondition employeeEducationCondition) {
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");

        return  employeeEducationService.getPagingList(employeeEducationCondition);
    }

    public static int add(EmployeeEducation employeeEducation){
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");

        return employeeEducationService.add(employeeEducation);
    }

    public static int update(EmployeeEducation employeeEducation){
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");

        return employeeEducationService.update(employeeEducation);
    }

    public static List<EmployeeEducation> getList(){
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");

        return employeeEducationService.getList();
    }

    public static EmployeeEducation getInfo(int id){
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");

        return employeeEducationService.getInfo(id);
    }

    public static List<EmployeeEducation> getEmpEduByEmpNo(int empNo) {
        EmployeeEducationService employeeEducationService = (EmployeeEducationService) context.getBean("employeeEducationService");
        return employeeEducationService.getEmpEduByEmpNo(empNo);
    }

}
