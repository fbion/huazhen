package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.Calendar;
import com.hzfh.api.baseInfo.model.query.CalendarCondition;
import com.hzfh.fmp.facade.baseInfo.CalendarFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CalendarModel {
    public static PagedList<Calendar> getPagingList(CalendarCondition calendarCondition) {
        return CalendarFacade.getPagingList(calendarCondition);
    }

    public static int add(Calendar calendar) {
        return CalendarFacade.add(calendar);
    }

    public static int update(Calendar calendar) {
        return CalendarFacade.update(calendar);
    }

    public static List<Calendar> getList() {
        return CalendarFacade.getList();
    }

    public static Calendar getInfo(int id) {
        return CalendarFacade.getInfo(id);
    }
    
    public static int deleteInfo(int id) {
        return CalendarFacade.delete(id);
    }
}
