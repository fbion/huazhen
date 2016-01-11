import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.service.CityService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CityServiceTest{
	@Test
	public void getListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CityService cityService = (CityService) context.getBean("cityService");
		List<City>  cityList = cityService.getList();
		for(City city : cityList){
			System.out.println(city.getCode() +" - " + city.getName());
		}
	}
	@Test
	public void getCityListByProvinceNoTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CityService cityService = (CityService) context.getBean("cityService");
		int provinceNo = 1;
		List<City>  cityList = cityService.getCityListByProvinceNo(provinceNo);
		for(City city : cityList){
			System.out.println(city.getCode() +" - " + city.getName());
		}
	}
	@Test
	public void getCityListByProvinceNoAndEnabledTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CityService cityService = (CityService) context.getBean("cityService");
		int provinceNo = 111;
		byte enabled = 1;
		List<City> cityList;
		try {
			cityList = cityService.getCityListByProvinceNoAndEnabled(provinceNo, enabled);
			for(City city : cityList){
				System.out.println(city.getCode() +" - " + city.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}