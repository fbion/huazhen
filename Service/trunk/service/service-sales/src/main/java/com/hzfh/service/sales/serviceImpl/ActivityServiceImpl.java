package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.api.sales.service.ActivityService;
import com.hzfh.service.sales.dao.ActivityDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityService")
public class ActivityServiceImpl extends BaseServiceImpl<Activity, ActivityCondition, ActivityDao> implements ActivityService {
}