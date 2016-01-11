package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.api.employee.service.FixedAssetsService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FixedAssetsFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<FixedAssets> getPagingList(FixedAssetsCondition fixedAssetsCondition) {
        FixedAssetsService fixedAssetsService = (FixedAssetsService) context.getBean("fixedAssetsService");

        return  fixedAssetsService.getPagingList(fixedAssetsCondition);
    }

    public static int add(FixedAssets fixedAssets){
        FixedAssetsService fixedAssetsService = (FixedAssetsService) context.getBean("fixedAssetsService");

        return fixedAssetsService.add(fixedAssets);
    }

    public static int update(FixedAssets fixedAssets){
        FixedAssetsService fixedAssetsService = (FixedAssetsService) context.getBean("fixedAssetsService");

        return fixedAssetsService.update(fixedAssets);
    }

    public static List<FixedAssets> getList(){
        FixedAssetsService fixedAssetsService = (FixedAssetsService) context.getBean("fixedAssetsService");

        return fixedAssetsService.getList();
    }

    public static FixedAssets getInfo(int id){
        FixedAssetsService fixedAssetsService = (FixedAssetsService) context.getBean("fixedAssetsService");

        return fixedAssetsService.getInfo(id);
    }
}
