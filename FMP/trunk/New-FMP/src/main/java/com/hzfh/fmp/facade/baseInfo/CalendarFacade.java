package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Calendar;
import com.hzfh.api.baseInfo.model.query.CalendarCondition;
import com.hzfh.api.baseInfo.service.CalendarService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CalendarFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Calendar> getPagingList(CalendarCondition calendarCondition) {
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return  calendarService.getPagingList(calendarCondition);
    }

    public static int add(Calendar calendar){
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return calendarService.add(calendar);
    }

    public static int update(Calendar calendar){
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return calendarService.update(calendar);
    }

    public static List<Calendar> getList(){
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return calendarService.getList();
    }

    public static Calendar getInfo(int id){
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return calendarService.getInfo(id);
    }
    
    public static int delete (int id){
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        return calendarService.delete(id);
    }
}
