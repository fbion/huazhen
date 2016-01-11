package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.api.employee.service.DepartmentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Department> getPagingList(DepartmentCondition departmentCondition) {
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return  departmentService.getPagingList(departmentCondition);
    }

    public static int add(Department department){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.add(department);
    }

    public static int update(Department department){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.update(department);
    }

    public static List<Department> getList(){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.getList();
    }

    public static Department getInfo(int id){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.getInfo(id);
    }

    @Deprecated
	public static List<Department> getDeptlistToCombox() {
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.getDeptlist();
	}

    public static List<Department> getDeptListByParentNo(int parentNo){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        return departmentService.getDeptListByParentNo(parentNo);
    }

	public static List<Department> getDeptListByCompanyNo(int companyNo) {
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		return departmentService.getDeptListByCompanyNo(companyNo);
	}
	

	public static List<Department> getDeptListByType(int deptType) {
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		return departmentService.getDeptListByType(deptType);
	}
	public static List<Department> getListByDistrictNo(int districtNo){
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        return departmentService.getListByDistrictNo(districtNo);
    }

	public static int getParentDeptByDept(int deptNo) {
	   DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
       return departmentService.getParentDeptByDept(deptNo);
	}

	public static List<Department> getDeptTypeBydeptNo(int deptNo) {
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		return departmentService.getDeptTypeBydeptNo(deptNo);
	}

	public static Department getDepartmentByDeptNo(int deptNo) {
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		return departmentService.getDepartmentByDeptNo(deptNo);
	}

}
