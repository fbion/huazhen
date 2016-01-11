package com.hzfh.fmp.facade.market;

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

	public static  List<ActivityUsers> getInfoByUsername(String name) {
		 ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");

	        return activityUsersService.getInfoByUsername(name);
	}

	public static List<ActivityUsers> getInfoByUsernameAndIds(String userName,
			List<Integer>  idList,int drawNo) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");
        return activityUsersService.getInfoByUsernameAndIds(userName,idList,drawNo);
	}

	public static List<ActivityUsers> getListByIds(String checkValue,List<Integer>  idList,int drawNo) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");
        return activityUsersService.getListByIds(checkValue,idList,drawNo);
	}

	public static List<ActivityUsers> getIntrinsicUsersByDrawNo(int id) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");
        return activityUsersService.getIntrinsicUsersByDrawNo(id);
	}

	public static List<ActivityUsers> getListByDrawNo(int drawNo) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");
        return activityUsersService.getListByDrawNo(drawNo);
	}

	public static List<ActivityUsers> getInfoByUsername(String userName,int drawNo) {
		ActivityUsersService activityUsersService = (ActivityUsersService) context.getBean("activityUsersService");
        return activityUsersService.getInfoByUsername(userName,drawNo);
	}
}
