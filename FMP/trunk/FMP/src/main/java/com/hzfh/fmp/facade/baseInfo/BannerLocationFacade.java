package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzfh.api.baseInfo.service.BannerLocationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BannerLocationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<BannerLocation> getPagingList(BannerLocationCondition bannerLocationCondition) {
        BannerLocationService bannerLocationService = (BannerLocationService) context.getBean("bannerLocationService");

        return  bannerLocationService.getPagingList(bannerLocationCondition);
    }

    public static int add(BannerLocation bannerLocation){
        BannerLocationService bannerLocationService = (BannerLocationService) context.getBean("bannerLocationService");

        return bannerLocationService.add(bannerLocation);
    }

    public static int update(BannerLocation bannerLocation){
        BannerLocationService bannerLocationService = (BannerLocationService) context.getBean("bannerLocationService");

        return bannerLocationService.update(bannerLocation);
    }

    public static List<BannerLocation> getList(){
        BannerLocationService bannerLocationService = (BannerLocationService) context.getBean("bannerLocationService");

        return bannerLocationService.getList();
    }

    public static BannerLocation getInfo(int id){
        BannerLocationService bannerLocationService = (BannerLocationService) context.getBean("bannerLocationService");

        return bannerLocationService.getInfo(id);
    }
}
