package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
import com.hzfh.api.baseInfo.service.ProvinceService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProvinceFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Province> getPagingList(ProvinceCondition provinceCondition) {
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return  provinceService.getPagingList(provinceCondition);
    }

    public static int add(Province province){
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return provinceService.add(province);
    }

    public static int update(Province province){
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return provinceService.update(province);
    }

    public static List<Province> getList(){
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return provinceService.getList();
    }

    public static Province getInfo(int id){
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return provinceService.getInfo(id);
    }
    public static List<Province> getListByEnabled(byte enabled){
        ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");

        return provinceService.getListByEnabled(enabled);
    }
}
