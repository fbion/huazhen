package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
import com.hzfh.service.customer.dao.ActivityPresentDao;
import com.hzfh.service.customer.mapper.ActivityPresentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("activityPresentDao")
public class ActivityPresentDaoImpl extends BaseDaoImpl<ActivityPresent, ActivityPresentCondition, ActivityPresentMapper> implements ActivityPresentDao {

	@Autowired
	ActivityPresentMapper activityPresentMapper;
	@Override
	public List<ActivityPresent> getActivityPresentByactId(int activityId) {
		return activityPresentMapper.getActivityPresentByactId(activityId);
	}
}