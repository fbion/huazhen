package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.service.sales.dao.ActivityDao;
import com.hzfh.service.sales.mapper.ActivityMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("activityDao")
public class ActivityDaoImpl extends BaseDaoImpl<Activity, ActivityCondition, ActivityMapper> implements ActivityDao {
}