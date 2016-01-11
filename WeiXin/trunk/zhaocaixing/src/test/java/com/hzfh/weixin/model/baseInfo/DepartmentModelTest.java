package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.employee.model.Department;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class DepartmentModelTest {

	@Test
	public void test() {
		List<Department> department = DepartmentModel.getListByDistrictNo(1);
		Iterator<Department> i = department.iterator();
		while(i.hasNext()){
			Department p = i.next();
			System.out.println(p.getName());
		}
	}

}
