package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Employee> getPagingList(EmployeeCondition employeeCondition) {
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return  employeeService.getPagingList(employeeCondition);
    }

    public static int add(Employee employee){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.add(employee);
    }

    public static int update(Employee employee){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.update(employee);
    }

    public static List<Employee> getList(){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getList();
    }
    public static List<Employee> getEmpListNoTest(){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getEmpListNoTest();
    }

    public static Employee getInfo(int id){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getInfo(id);
    }
    public static List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        return employeeService.getInfoByCondition(employeeCondition);
    }

    @Deprecated
	public static List<Employee> getEmpListByEmpId(int empId) {
		 EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
	        return employeeService.getEmpListByEmpId(empId);
	}

	public static Employee getEmpByUserId(int id) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpByUserId(id);
	}

	public static List<Employee> getEmpListByDept(int deptNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByDept(deptNo);
	}
	public static List<Employee> getEmpListByDeptAndStatus(int deptNo,String status) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByDeptAndStatus(deptNo,status);
	}
	public static List<Employee> getEmpListByParentNo(int id) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByParentNo(id);
	}
	
	public static List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,int storeNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpByPositionNoAndStoreNo(positionNo, storeNo);
	}
	public static List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,int storeNo,int status) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpByPositionNoAndStoreNoIsUse(positionNo, storeNo,status);
	}

	public static int addFilePath(Employee employeeFile) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.addFilePath(employeeFile);
	}

	public static List<Employee> getEmpListByPositionNo(int positionNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByPositionNo(positionNo);
	}

	public static int updateEmpByEmpDetail(Employee employee){
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return  employeeService.updateEmpByEmpDetail(employee);
	}

	public static Employee getEmpByEmpName(String byName) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return  employeeService.getEmpByEmpName(byName);
	}

    public static int updateIsSendEmailById(int id){
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        return employeeService.updateIsSendEmailById(id);
    }

	public static List<Employee> getNowEmpListByPositionNo(int positionNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getNowEmpListByPositionNo(positionNo);
	}

	public static List<Employee> getEmpListByStatus(int status) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListByStatus(status);
	}

	public static List<Employee> getEmpListIsTest(byte isTest) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getEmpListIsTest(isTest);
	}

	public static int updateCheckById(int id,byte status){
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.updateCheckById(id,status);
	}

	public static int updateStatusByEmpNo(int empNo) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.updateStatusByEmpNo(empNo);
	}

	public static List<Employee> getListForExcel(EmployeeCondition employeeCondition) {
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		return employeeService.getListForExcel(employeeCondition);
	}




}
