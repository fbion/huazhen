package com.hzfh.market.facade.sales;

import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzfh.api.sales.service.ActivityAttachmentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityAttachmentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<ActivityAttachment> getPagingList(ActivityAttachmentCondition activityAttachmentCondition) {
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");

        return  activityAttachmentService.getPagingList(activityAttachmentCondition);
    }

    public static int add(ActivityAttachment activityAttachment){
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");

        return activityAttachmentService.add(activityAttachment);
    }

    public static int update(ActivityAttachment activityAttachment){
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");

        return activityAttachmentService.update(activityAttachment);
    }

    public static List<ActivityAttachment> getList(){
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");

        return activityAttachmentService.getList();
    }

    public static ActivityAttachment getInfo(int id){
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");

        return activityAttachmentService.getInfo(id);
    }

	public static List<ActivityAttachment> getListByActivityNo(int activityNo) {
		ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");
		return activityAttachmentService.getListByActivityNo(activityNo);
	}

	public static int updateStatus(int id, byte status) {
		ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");
		return activityAttachmentService.updateStatus(id,status);
	}

	public static List<ActivityAttachment> getListBySalesNo(int activityNo) {
		ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");
		return activityAttachmentService.getListBySalesNo(activityNo);
	}
    public static List<ActivityAttachment> getListBySalesNoAndType(int activityNo,int type) {
        ActivityAttachmentService activityAttachmentService = (ActivityAttachmentService) context.getBean("activityAttachmentService");
        return activityAttachmentService.getListBySalesNoAndType(activityNo,type);
    }

}
