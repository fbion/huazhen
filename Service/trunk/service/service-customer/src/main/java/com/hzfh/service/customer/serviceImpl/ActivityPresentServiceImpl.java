package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
import com.hzfh.api.customer.service.ActivityPresentService;
import com.hzfh.service.customer.dao.ActivityPresentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityPresentService")
public class ActivityPresentServiceImpl extends BaseServiceImpl<ActivityPresent, ActivityPresentCondition, ActivityPresentDao> implements ActivityPresentService {
	@Autowired
	ActivityPresentDao activityPresentDao;
	@Override
	public List<ActivityPresent> getActivityPresentByactId(int activityId) {
		return activityPresentDao.getActivityPresentByactId(activityId);
	}
}