package com.hzfh.market.facade.market;


import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.api.market.service.ActivityApplyUserService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityApplyUserFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-market.xml");

    public static PagedList<ActivityApplyUser> getPagingList(ActivityApplyUserCondition activityApplyUserCondition) {
        ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");

        return  activityApplyUserService.getPagingList(activityApplyUserCondition);
    }

    public static int add(ActivityApplyUser activityApplyUser){
        ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");

        return activityApplyUserService.add(activityApplyUser);
    }

    public static int update(ActivityApplyUser activityApplyUser){
        ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");

        return activityApplyUserService.update(activityApplyUser);
    }

    public static List<ActivityApplyUser> getList(){
        ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");

        return activityApplyUserService.getList();
    }

    public static ActivityApplyUser getInfo(int id){
        ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");

        return activityApplyUserService.getInfo(id);
    }
    
    public static ActivityApplyUser getInfoByCellphone(String cellphone,int id){
    	 ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");
    	 
    	 return activityApplyUserService.getInfoByCellphone(cellphone,id);
    }
}
