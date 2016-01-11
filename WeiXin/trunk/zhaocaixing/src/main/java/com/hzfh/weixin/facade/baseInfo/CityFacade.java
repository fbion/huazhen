package com.hzfh.weixin.facade.baseInfo;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzfh.api.baseInfo.service.CityService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CityFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<City> getPagingList(CityCondition cityCondition) {
        CityService cityService = (CityService) context.getBean("cityService");

        return  cityService.getPagingList(cityCondition);
    }

    public static int add(City city){
        CityService cityService = (CityService) context.getBean("cityService");

        return cityService.add(city);
    }

    public static int update(City city){
        CityService cityService = (CityService) context.getBean("cityService");

        return cityService.update(city);
    }

    public static List<City> getList(){
        CityService cityService = (CityService) context.getBean("cityService");

        return cityService.getList();
    }

    public static City getInfo(int id){
        CityService cityService = (CityService) context.getBean("cityService");

        return cityService.getInfo(id);
    }

	public static List<City> getCityListByProvinceNo(int provinceNo) {
		CityService cityService = (CityService) context.getBean("cityService");

        return cityService.getCityListByProvinceNo(provinceNo);
	}
	public static List<City> getCityListByProvinceNoAndEnabled(int provinceNo,byte enabled) {
		CityService cityService = (CityService) context.getBean("cityService");
		
		return cityService.getCityListByProvinceNoAndEnabled(provinceNo, enabled);
	}
	
	
}
