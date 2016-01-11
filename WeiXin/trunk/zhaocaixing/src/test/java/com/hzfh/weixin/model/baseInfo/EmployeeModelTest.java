package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.employee.model.Employee;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class EmployeeModelTest {

	@Test
	public void test() {
		List<Employee> employeeList = EmployeeModel.getListByDepartmentNo(2);
		Iterator<Employee> i = employeeList.iterator();
		while(i.hasNext()){
			Employee p = i.next();
			System.out.println(p.getName());
		}
	}

}
