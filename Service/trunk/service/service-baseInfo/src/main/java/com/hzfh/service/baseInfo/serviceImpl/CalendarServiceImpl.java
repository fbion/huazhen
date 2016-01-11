package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Calendar;
import com.hzfh.api.baseInfo.model.query.CalendarCondition;
import com.hzfh.api.baseInfo.service.CalendarService;
import com.hzfh.service.baseInfo.dao.CalendarDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("calendarService")
public class CalendarServiceImpl extends BaseServiceImpl<Calendar, CalendarCondition, CalendarDao> implements CalendarService {
}