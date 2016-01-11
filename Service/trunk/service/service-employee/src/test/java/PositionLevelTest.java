import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.service.PositionLevelService;
import com.hzfh.api.employee.service.PositionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.util.List;

public class PositionLevelTest {

	@Test
	public void hessianTest() throws MalformedURLException {
		String url = "http://localhost:8080/service-employee/positionLevel";
		HessianProxyFactory factory = new HessianProxyFactory();
		PositionLevelService employeeService = (PositionLevelService) factory.create(
				PositionLevelService.class, url);
		List<PositionLevel> empList = employeeService.getList();
		for (PositionLevel employee : empList) {
			System.out.println(employee.getId() + ":========>>>>"
					+ employee.getName());
		}
	}
	
	
//	getPositionListBydept
	@Test
	public void getEmplistTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PositionService positionService = (PositionService) context.getBean("positionService");
		int d = 42;
		List<Position> positionList = positionService.getPositionByDept(d);

		System.out.println("positionList");
		for (Position position : positionList) {
			System.out.println(position.getId() + ":" + position.getName()
					+ ":" + position.getDeptNo());
		}
	}
	
	@Test
	public void getPositionLevelListByDept() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");
		int d = 1;
		List<PositionLevel> positionLevelList = positionLevelService.getPositionLevelListByDept(d);

		System.out.println("positionLevelList");
		for (PositionLevel positionLevel : positionLevelList) {
			System.out.println(positionLevel.getId() + ":" + positionLevel.getName()
					+ ":" + positionLevel.getDeptNo());
		}
	}
	
	
	
}