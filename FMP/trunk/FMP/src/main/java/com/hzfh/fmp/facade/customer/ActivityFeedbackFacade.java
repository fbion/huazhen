package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityFeedback;
import com.hzfh.api.customer.model.query.ActivityFeedbackCondition;
import com.hzfh.api.customer.service.ActivityFeedbackService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityFeedbackFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityFeedback> getPagingList(ActivityFeedbackCondition activityFeedbackCondition) {
        ActivityFeedbackService activityFeedbackService = (ActivityFeedbackService) context.getBean("activityFeedbackService");

        return  activityFeedbackService.getPagingList(activityFeedbackCondition);
    }

    public static int add(ActivityFeedback activityFeedback){
        ActivityFeedbackService activityFeedbackService = (ActivityFeedbackService) context.getBean("activityFeedbackService");

        return activityFeedbackService.add(activityFeedback);
    }

    public static int update(ActivityFeedback activityFeedback){
        ActivityFeedbackService activityFeedbackService = (ActivityFeedbackService) context.getBean("activityFeedbackService");

        return activityFeedbackService.update(activityFeedback);
    }

    public static List<ActivityFeedback> getList(){
        ActivityFeedbackService activityFeedbackService = (ActivityFeedbackService) context.getBean("activityFeedbackService");

        return activityFeedbackService.getList();
    }

    public static ActivityFeedback getInfo(int id){
        ActivityFeedbackService activityFeedbackService = (ActivityFeedbackService) context.getBean("activityFeedbackService");

        return activityFeedbackService.getInfo(id);
    }
}
