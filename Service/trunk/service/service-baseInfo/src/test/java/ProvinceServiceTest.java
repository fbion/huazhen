import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.service.ProvinceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProvinceServiceTest{
	@Test
	public void getListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");
		List<Province>  provinceList = provinceService.getList();
//		for(Province province : provinceList){
//			System.out.println(province.getCode() +" - " + province.getName());
//		}
        System.out.println(provinceList.size());
	}
	@Test 
	public void getListByEnabledTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");
		byte i = 1;
		List<Province>  provinceList = provinceService.getListByEnabled(i);
		System.out.println(provinceList.size());
	}
}