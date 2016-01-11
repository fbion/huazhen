import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.service.DecisionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DecisionTest {

	@Test
	public void getListByProductNo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DecisionService decisionService = (DecisionService) context.getBean("decisionService");

		int productNo = 9;
		List<Decision> decisionList = decisionService.getListByProductNo(productNo);
		for (Decision decision : decisionList) {
			System.out.println(
			"====>>"+decision.getId()
			+"====>>"+decision.getCheckTime()
			+"====>>"+decision.getDepNo()
			+"====>>"+decision.getIsOk()
			+"====>>"+decision.getCheckTime());
		}
		
		}
	
}
