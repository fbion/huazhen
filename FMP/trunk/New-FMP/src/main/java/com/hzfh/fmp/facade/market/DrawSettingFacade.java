package com.hzfh.fmp.facade.market;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.api.market.service.DrawSettingService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DrawSettingFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-market.xml");

    public static PagedList<DrawSetting> getPagingList(DrawSettingCondition drawSettingCondition) {
        DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");

        return  drawSettingService.getPagingList(drawSettingCondition);
    }

    public static int add(DrawSetting drawSetting){
        DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");

        return drawSettingService.add(drawSetting);
    }

    public static int update(DrawSetting drawSetting){
        DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");

        return drawSettingService.update(drawSetting);
    }

    public static List<DrawSetting> getList(){
        DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");

        return drawSettingService.getList();
    }

    public static DrawSetting getInfo(int id){
        DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");

        return drawSettingService.getInfo(id);
    }

	public static List<DrawSetting> getInfoListByStatus(int drawStatus) {
		DrawSettingService drawSettingService = (DrawSettingService) context.getBean("drawSettingService");
        return drawSettingService.getInfoListByStatus(drawStatus);
	}
}
