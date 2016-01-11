package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.api.baseInfo.service.BannerInfoService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BannerInfoFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<BannerInfo> getPagingList(BannerInfoCondition bannerInfoCondition) {
        BannerInfoService bannerInfoService = (BannerInfoService) context.getBean("bannerInfoService");

        return  bannerInfoService.getPagingList(bannerInfoCondition);
    }

    public static int add(BannerInfo bannerInfo){
        BannerInfoService bannerInfoService = (BannerInfoService) context.getBean("bannerInfoService");

        return bannerInfoService.add(bannerInfo);
    }

    public static int update(BannerInfo bannerInfo){
        BannerInfoService bannerInfoService = (BannerInfoService) context.getBean("bannerInfoService");

        return bannerInfoService.update(bannerInfo);
    }

    public static List<BannerInfo> getList(){
        BannerInfoService bannerInfoService = (BannerInfoService) context.getBean("bannerInfoService");

        return bannerInfoService.getList();
    }

    public static BannerInfo getInfo(int id){
        BannerInfoService bannerInfoService = (BannerInfoService) context.getBean("bannerInfoService");

        return bannerInfoService.getInfo(id);
    }
}
