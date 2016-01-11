import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.service.CompanyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CompanyTest {
	@Test
	public void add(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyService companyService=(CompanyService) context.getBean("companyService");
		Company company = new Company();
		company.setCode("XXX");
		int dept=companyService.add(company);
		System.out.println(dept);
	}

	@Test
	public void getListTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyService companyService=(CompanyService) context.getBean("companyService");
		Company company = companyService.getInfo(1);
		System.out.print(company.getName()+company.getInTime()+"\n"+company.getEditTime());
	}
	
}
