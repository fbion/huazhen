package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzfh.api.employee.service.EmployeeCredentialService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeCredentialFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EmployeeCredential> getPagingList(EmployeeCredentialCondition employeeCredentialCondition) {
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");

        return  employeeCredentialService.getPagingList(employeeCredentialCondition);
    }

    public static int add(EmployeeCredential employeeCredential){
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");

        return employeeCredentialService.add(employeeCredential);
    }

    public static int update(EmployeeCredential employeeCredential){
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");

        return employeeCredentialService.update(employeeCredential);
    }

    public static List<EmployeeCredential> getList(){
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");

        return employeeCredentialService.getList();
    }

    public static EmployeeCredential getInfo(int id){
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");

        return employeeCredentialService.getInfo(id);
    }

    public static List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo) {
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");
        return employeeCredentialService.getEmpCredentialByEmpNo(empNo);
    }
}
