import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.service.CommissionWealthCenterService;
import com.hzfh.api.employee.service.DepartmentService;
import com.hzfh.api.employee.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DeptTest {
	@Test
	public void getDeptByDeptId() throws Exception{
        String url =
                "http://employeeservice.hzfh.com:8080/service-employee/department";
        HessianProxyFactory factory = new HessianProxyFactory();
        DepartmentService departmentService = (DepartmentService)
                factory.create(DepartmentService.class, url);
//		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		List<Department> dept = departmentService.getDeptListByType(1);
		System.out.println(dept.size());
	}

    @Test
    public void getInfoTest() throws Exception {

        String url =
                "http://employeeservice.hzfh.com:8080/service-employee/department";
        HessianProxyFactory factory = new HessianProxyFactory();
        DepartmentService departmentService = (DepartmentService)
                factory.create(DepartmentService.class, url);

//        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
        Department dept=departmentService.getInfo(1);
        System.out.println(dept.getName());
    }
	
	//
	@Test
	public void getDeptListByParentNo(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		List<Department> dept=deptService.getDeptListByParentNo(1);
		for (Department department : dept) {
			System.out.println(
				department.getId()+"====>>"+
				department.getParentNo()+"=====》"+
				department.getName()+"====>>"+
				department.getDuty()
					);
		}
	}
	//getDeptListByCompanyNo
	@Test
	public void getDeptListByCompanyNo(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		int companyNo = 1;
		List<Department> dept=deptService.getDeptListByCompanyNo(companyNo);
		for (Department department : dept) {
			System.out.println(
				department.getId()+"====>>"+
				department.getParentNo()+"=====》"+
				department.getName()+"====>>"+
				department.getDuty()
					);
		}
	}
	@Test
	public void getDeptListByTypeTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		int deptType = 0 ;
		List<Department> deptList = deptService.getDeptListByType(deptType);
		System.out.println(deptList.size());
	}
	@Test
	public void getListByDistrictNoTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		int districtNo = 1 ;
		List<Department> deptList = deptService.getListByDistrictNo(districtNo);
		System.out.println(deptList.size());
	}
	
	@Test
	public void getEmpByPositionNoAndStoreNoTest() throws Exception{
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService empService=(EmployeeService) context.getBean("employeeService");
		List<Employee> empList = empService.getEmpByPositionNoAndStoreNo(1, 8);
		System.out.println(empList.size());
        System.out.println("###############");
		
	}
	@Test
	public void getParentDeptByDept(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService deptService=(DepartmentService) context.getBean("departmentService");
		int districtNo = 1 ;
		int result = deptService.getParentDeptByDept(districtNo);
		System.out.println(result);
	}
	
	
	
	
}
