import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.service.PartnerRateService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class PartnerRateTest {
	@Test
	public void getPartnerRateListByProductNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");
		List<PartnerRate> partnerRateList = partnerRateService.getListByProductNo(12);
		for(PartnerRate partnerRate:partnerRateList){
			System.out.println(partnerRate.getRate());
		}
	}
    @Test
    public void delete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");
        int delete = partnerRateService.delete(10);
        System.out.print(delete);
    }

}
