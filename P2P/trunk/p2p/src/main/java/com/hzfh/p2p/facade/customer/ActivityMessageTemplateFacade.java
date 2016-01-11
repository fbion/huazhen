package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityMessageTemplate;
import com.hzfh.api.customer.model.query.ActivityMessageTemplateCondition;
import com.hzfh.api.customer.service.ActivityMessageTemplateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityMessageTemplateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityMessageTemplate> getPagingList(ActivityMessageTemplateCondition activityMessageTemplateCondition) {
        ActivityMessageTemplateService activityMessageTemplateService = (ActivityMessageTemplateService) context.getBean("activityMessageTemplateService");

        return  activityMessageTemplateService.getPagingList(activityMessageTemplateCondition);
    }

    public static int add(ActivityMessageTemplate activityMessageTemplate){
        ActivityMessageTemplateService activityMessageTemplateService = (ActivityMessageTemplateService) context.getBean("activityMessageTemplateService");

        return activityMessageTemplateService.add(activityMessageTemplate);
    }

    public static int update(ActivityMessageTemplate activityMessageTemplate){
        ActivityMessageTemplateService activityMessageTemplateService = (ActivityMessageTemplateService) context.getBean("activityMessageTemplateService");

        return activityMessageTemplateService.update(activityMessageTemplate);
    }

    public static List<ActivityMessageTemplate> getList(){
        ActivityMessageTemplateService activityMessageTemplateService = (ActivityMessageTemplateService) context.getBean("activityMessageTemplateService");

        return activityMessageTemplateService.getList();
    }

    public static ActivityMessageTemplate getInfo(int id){
        ActivityMessageTemplateService activityMessageTemplateService = (ActivityMessageTemplateService) context.getBean("activityMessageTemplateService");

        return activityMessageTemplateService.getInfo(id);
    }
}
