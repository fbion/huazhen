package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Calendar;
import com.hzfh.api.baseInfo.model.query.CalendarCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("calendarMapper")
public interface CalendarMapper extends BaseMapper<Calendar, CalendarCondition> {
}