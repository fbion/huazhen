package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
import com.hzfh.api.baseInfo.service.DistrictService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DistrictFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<District> getPagingList(DistrictCondition districtCondition) {
        DistrictService districtService = (DistrictService) context.getBean("districtService");

        return  districtService.getPagingList(districtCondition);
    }

    public static int add(District district){
        DistrictService districtService = (DistrictService) context.getBean("districtService");

        return districtService.add(district);
    }

    public static int update(District district){
        DistrictService districtService = (DistrictService) context.getBean("districtService");

        return districtService.update(district);
    }

    public static List<District> getList(){
        DistrictService districtService = (DistrictService) context.getBean("districtService");

        return districtService.getList();
    }

    public static District getInfo(int id){
        DistrictService districtService = (DistrictService) context.getBean("districtService");

        return districtService.getInfo(id);
    }

	public static List<District> getDistrictListByCityNo(int cityNo) {
		 DistrictService districtService = (DistrictService) context.getBean("districtService");

	        return districtService.getDistrictListByCityNo(cityNo);
	}
	public static List<District> getDistrictListByCityNoAndEnabled(int cityNo,byte enabled) {
		DistrictService districtService = (DistrictService) context.getBean("districtService");
		
		return districtService.getDistrictListByCityNoAndEnabled(cityNo, enabled);
	}
}
