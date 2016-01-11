import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.service.DistrictService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DistrictServiceTest{
	@Test
	public void getListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DistrictService districtService = (DistrictService) context.getBean("districtService");
		List<District>  districtList = districtService.getList();
		for(District district : districtList){
			System.out.println(district.getCode() +" - " + district.getName());
		}
	}
	@Test
	public void getDistrictListByCityNoAndEnabledTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DistrictService districtService = (DistrictService) context.getBean("districtService");
		
		int cityNo = 1;
		byte enabled =1;
		List<District>  districtList = districtService.getDistrictListByCityNoAndEnabled(cityNo, enabled);
		for(District district : districtList){
			System.out.println(district.getCode() +" - " + district.getName());
		}
	}
}