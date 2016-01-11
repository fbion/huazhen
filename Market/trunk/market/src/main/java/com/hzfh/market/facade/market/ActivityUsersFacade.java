package com.hzfh.market.facade.market;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.api.market.service.ActivityUsersService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityUsersFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-market.xml");

    public static PagedList<ActivityUsers> getPagingList(ActivityUsersCondition activityUsersCondition) {
        ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return  activityUsersService.getPagingList(activityUsersCondition);
    }

    public static int add(ActivityUsers activityUsers){
        ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.add(activityUsers);
    }

    public static int update(ActivityUsers activityUsers){
        ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.update(activityUsers);
    }

    public static List<ActivityUsers> getList(){
        ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getList();
    }

    public static ActivityUsers getInfo(int id){
        ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getInfo(id);
    }

	public static List<ActivityUsers> getListByIsWin(int isWin) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getListByIsWin(isWin);
	}

	public static List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getIntrinsicUsersByDrawNo(drawNo);
	}

	public static List<ActivityUsers> getOtherWinersByIsWin(int isWin,
			int otherNum) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getOtherWinersByIsWin(isWin,otherNum);
	}

	public static ActivityUsers getInfoByOpenId(String openid) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

        return activityUsersService.getInfoByOpenId(openid);
	}
}
