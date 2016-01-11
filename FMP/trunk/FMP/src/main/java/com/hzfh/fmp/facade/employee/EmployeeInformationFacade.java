package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.api.employee.service.EmployeeInformationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public class EmployeeInformationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");
    public static List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition){
        EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.getBean("employeeInformationService");
        return employeeInformationService.getListForExcel(employeeInformationCondition);
    }
    public static List<EmployeeInformation> getListForExcelByType(int type){
        EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.getBean("employeeInformationService");
        return employeeInformationService.getListForExcelByType(type);
    }
	public static List<EmployeeInformation> getExtendEmp() {
		 EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.getBean("employeeInformationService");
	        return employeeInformationService.getExtendEmp();
	}
	public static EmployeeInformation getInfo(Integer id1) {
		 EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.getBean("employeeInformationService");
	        return employeeInformationService.getInfo(id1);
	}
}
