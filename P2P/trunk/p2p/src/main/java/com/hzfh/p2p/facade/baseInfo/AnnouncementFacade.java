package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.api.baseInfo.service.AnnouncementService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AnnouncementFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Announcement> getPagingList(AnnouncementCondition announcementCondition) {
        AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return  announcementService.getPagingList(announcementCondition);
    }

    public static int add(Announcement announcement){
        AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return announcementService.add(announcement);
    }

    public static int update(Announcement announcement){
        AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return announcementService.update(announcement);
    }

    public static List<Announcement> getList(){
        AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return announcementService.getList();
    }

    public static Announcement getInfo(int id){
        AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return announcementService.getInfo(id);
    }

	public static List<Announcement> getAnnouncementTitleList(AnnouncementCondition announcementCondition) {
		AnnouncementService announcementService = (AnnouncementService) context.getBean("announcementService");

        return announcementService.getAnnouncementTitleList(announcementCondition);
	}
}
