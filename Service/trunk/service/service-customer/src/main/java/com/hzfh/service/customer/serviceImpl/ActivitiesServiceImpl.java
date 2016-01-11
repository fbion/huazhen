package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.api.customer.service.ActivitiesService;
import com.hzfh.service.customer.dao.ActivitiesDao;
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


@Service("activitiesService")
public class ActivitiesServiceImpl extends BaseServiceImpl<Activities, ActivitiesCondition, ActivitiesDao> implements ActivitiesService {
	@Autowired
	private ActivitiesDao activitiesDao;
	public Activities getInfoByActivitytype(int type) {
		return activitiesDao.getInfoByActivitytype(type);
	}
	@Override
	public int updateActivitiesByIdAndStatus(int id, int status) {
		return activitiesDao.updateActivitiesByIdAndStatus(id,status);
	}
	@Override
	public int getActivitiesTypeCountById(int activityType) {
		return activitiesDao.getActivitiesTypeCountById(activityType);
	}
	@Override
	public int getConds(int id,int activityType) {
		return activitiesDao.getConds(id,activityType);
	}
	@Override
	public int getBouns(int condId, int activityType) {
		return activitiesDao.getBouns(condId,activityType);
	}
}