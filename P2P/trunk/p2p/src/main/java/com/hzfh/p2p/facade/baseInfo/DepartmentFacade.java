package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.api.employee.service.DepartmentService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentFacade {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");
	    public static List<Department> getListByDistrictNo(int districtNo) {
	        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
	        return  departmentService.getListByDistrictNo(districtNo);
	    }

		public static PagedList<Department> getPagingList(DepartmentCondition departmentCondition) {
			DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
			return departmentService.getPagingList(departmentCondition);
		}
		public static Department getInfo(int id) {
			DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
			return departmentService.getInfo(id);
		}
}
