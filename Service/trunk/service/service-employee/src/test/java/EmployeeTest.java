import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.employee.service.CompanyService;
import com.hzfh.api.employee.service.DepartmentService;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

public class EmployeeTest {
	@Test
	public void getEmplistTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmployeeService employeeService = (EmployeeService) context
				.getBean("employeeService");

		List<Employee> employeeList = employeeService.getEmpListNoTest();

		System.out.println("getListTest");
		for (Employee employee : employeeList) {
			System.out.println(employee.getId() + ":" + employee.getName()
					+ ":" + employee.getCode());
		}
	}

	@Test
	public void getPagingListTest() throws Exception {
        String url =
                "http://employeeservice.hzfh.com:8080/service-employee/employee";
        HessianProxyFactory factory = new HessianProxyFactory();
        EmployeeService employeeService = (EmployeeService)
                factory.create(EmployeeService.class, url);

//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		EmployeeService employeeService = (EmployeeService) context
//				.getBean("employeeService");
		EmployeeCondition employeeCondition = new EmployeeCondition();
		employeeCondition.setPageIndex(1);
		employeeCondition.setPageSize(2);
		employeeCondition.setTotalCount(9);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
        employeeCondition.setSortItemList(sortItemList);

        employeeCondition.setByStatus("");

		PagedList<Employee> employeePagedList = employeeService
				.getPagingList(employeeCondition);
		System.out.println("getPagingListTest");
		for (Employee employee : employeePagedList.getResultList()) {
			System.out.println(employee.getUserNo());
		}
	}

	@Test
	public void updateCheckByIdTest() throws Exception {
        String url =
                "http://employeeservice.hzfh.com:8080/service-employee/employee";
        HessianProxyFactory factory = new HessianProxyFactory();
        EmployeeService employeeService = (EmployeeService)
                factory.create(EmployeeService.class, url);
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		EmployeeService employeeService = (EmployeeService) context
//				.getBean("employeeService");

		int result = employeeService.updateCheckById(999,(byte)1);

		System.out.println("getInfoTest");
		System.out.println(result);
	}

	@Test
	public void updateTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmployeeService employeeService = (EmployeeService) context
				.getBean("employeeService");

		Employee employee = new Employee();
		employee.setName("华镇金控");
		employee.setCode("9999");
		employee.setId(999);
		employee.setStatus(0);

		int ret = employeeService.update(employee);
		Employee e = new Employee();
		e = employeeService.getInfo(999);
		System.out.println(e.getStatus());
	}

    @Test	//根据用户id 查询员工信息
    public void getEmpByUserId(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee emp=employeeService.getEmpByUserId(1);
        System.out.println(emp.getName());
    }
    
	@Test
	public void getDeptlist() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		List<Department> departmentList = departmentService.getDeptlist();
		for (Department department : departmentList) {
			System.out.println(department.getId() + ":=======>"+ department.getName());
		}
	}
	
	@Test
	public void getCompanylist() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyService companyService = (CompanyService) context.getBean("companyService");
		List<Company> companyList = companyService.getCompanylist();
		for (Company company : companyList) {
			System.out.println(company.getId() + ":=======>" + company.getName());
		}
	}
	
	@Test
	public void getPagingList() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyService companyService = (CompanyService) context.getBean("companyService");
		CompanyCondition companyCondition=new CompanyCondition();
		companyCondition.setName("上");
		companyCondition.setPageIndex(1);
		companyCondition.setPageSize(4);
		List<SortItem> sortItemList=new ArrayList<SortItem>();
		SortItem sortItem1=new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.ASC);
		sortItemList.add(sortItem1);
		companyCondition.setSortItemList(sortItemList);
		
		PagedList<Company> companyList =   companyService.getPagingList(companyCondition);
		for (Company company : companyList.getResultList()) {
			System.out.println(company.getId() + ":=======>" + company.getName());
		}
	}
	@Test
	public void getEmpByDept(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        List<Employee> empList=employeeService.getEmpListByDeptAndStatus(14, "1");
        for(Employee emp : empList){
        	System.out.println(emp.getName());
        }
	}
	
	@Test	//根据员工EmpId 查询员工姓名 用户id
	public void getEmpListByParentNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        int id = 1;
        List<Employee> testList=employeeService.getEmpListByParentNo(id);
        for (Employee employee : testList) {
			System.out.println(employee.getName()+"===>>"+employee.getUserNo());
		}
        
	}
	//addFilePath
	@Test	//根据员工EmpId 查询员工姓名 用户id
	public void addFilePath(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        int id = 1; 
        Employee employee = new Employee();
        employee.setId(1);
        employee.setPortraitPath("http://localhost:8080/upload/files/2015/3/30/20150330182048504_C360_2015-03-11-13-46-10-118.jpg");
        int result=employeeService.addFilePath(employee);
        Employee employee1 = new Employee();
        employee1 = employeeService.getInfo(1);
		System.out.println(employee1.getPortraitPath());
        
	}
	
	@Test
	public void update(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee();
        employee.setId(1103);
        employee.setStatus(1);
        int result=employeeService.update(employee);
        Employee employee1 = new Employee();
        employee1 = employeeService.getInfo(1103);
		System.out.println(employee1.getStatus());
        
	}
	@Test
	public void getEmpListByDeptAndStatusListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		int deptNo = 14;
		List<Integer>  statusList= new ArrayList<Integer>();
		statusList.add(1);
		statusList.add(4);
		statusList.add(5);
		
		List<Employee> employees = employeeService.getEmpListByDeptAndStatusList(deptNo, statusList);
		for (Employee employee : employees) {
			System.out.println(employee.getName()+" - "+employee.getStatus());
		}
		
	}
    @Test
    public void updateIsSendEmailByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        int result = employeeService.updateIsSendEmailById(1089);
        System.out.println(result);
    }
    @Test
    public void addTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee();
        employee.setAddress("sdfs");
        employee.setCellphone1("458");
        employee.setCompanyNo(3);
        employee.setDeptNo(6);
        employee.setEmail("xdsfvrd");
        employee.setIsSendEmail(0);
        employee.setMarry((byte)0);
        employee.setName("xsd");
        employee.setParentNo(4);
        employee.setPositionNo(5);
        employee.setCode("aa");
        employee.setParentNo(5);

        //employee.set
        employeeService.add(employee);
    }

	
}
