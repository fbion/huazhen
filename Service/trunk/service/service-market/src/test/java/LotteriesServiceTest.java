import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.service.LotteriesService;


public class LotteriesServiceTest {
	@Test
	public  void getLotteriesByRandTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LotteriesService lotteriesService = (LotteriesService) context.getBean("lotteriesService");
		Lotteries lotteries =lotteriesService.getLotteriesByRand();
		
		System.out.println(lotteries.getCode());
	}

	@Test
	public  void updateOpenIdByIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LotteriesService lotteriesService = (LotteriesService) context.getBean("lotteriesService");
		String openId ="222";
		int id=38;
		int n = lotteriesService.updateOpenIdById(openId,id);
		System.out.println(n);
	}

	@Test
	public  void getLotteriesByOpenId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LotteriesService lotteriesService = (LotteriesService) context.getBean("lotteriesService");
		String openId = "121";
		Lotteries lotteries = lotteriesService.getLotteriesByOpenId(openId);
		if(lotteries==null){
			System.out.println("null");
		}else{
			System.out.println("NO null");
		}
	}

	@Test
	public  void getLotteriesListByHasOpenIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LotteriesService lotteriesService = (LotteriesService) context.getBean("lotteriesService");
		List<Lotteries> lotteriesList= lotteriesService.getLotteriesListByHasOpenId();
		for (Lotteries lotteries : lotteriesList) {
			System.out.println(lotteries.getCode());
		}
	}
}
