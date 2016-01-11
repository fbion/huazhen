package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzfh.api.employee.service.EmployeeDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EmployeeDetail> getPagingList(EmployeeDetailCondition employeeDetailCondition) {
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");

        return  employeeDetailService.getPagingList(employeeDetailCondition);
    }

    public static int add(EmployeeDetail employeeDetail){
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");

        return employeeDetailService.add(employeeDetail);
    }

    public static int update(EmployeeDetail employeeDetail){
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");

        return employeeDetailService.update(employeeDetail);
    }

    public static List<EmployeeDetail> getList(){
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");

        return employeeDetailService.getList();
    }

    public static EmployeeDetail getInfo(int id){
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");

        return employeeDetailService.getInfo(id);
    }

    public static EmployeeDetail getEmpDetailByEmpNo(int empNo) {
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        return employeeDetailService.getEmpDetailByEmpNo(empNo);
    }

    public static int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail) {
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        return employeeDetailService.updateEmpDetailByEmpNo(employeeDetail);
    }

    public static int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo) {
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        return employeeDetailService.updateEmpDetailByOtherInfo(empDetailInfo);
    }
}
