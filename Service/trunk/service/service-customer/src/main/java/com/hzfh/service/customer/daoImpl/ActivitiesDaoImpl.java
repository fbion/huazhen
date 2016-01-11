package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.service.customer.dao.ActivitiesDao;
import com.hzfh.service.customer.mapper.ActivitiesMapper;
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


@Service("activitiesDao")
public class ActivitiesDaoImpl extends BaseDaoImpl<Activities, ActivitiesCondition, ActivitiesMapper> implements ActivitiesDao {

	@Autowired
	private ActivitiesMapper activitiesMapper;

	@Override
	public Activities getInfoByActivitytype(int type) {
		return activitiesMapper.getInfoByActivitytype(type);
	}

	@Override
	public int updateActivitiesByIdAndStatus(int id, int status) {
		return activitiesMapper.updateActivitiesByIdAndStatus(id,status);
	}

	@Override
	public int getActivitiesTypeCountById(int activityType) {
		return activitiesMapper.getActivitiesTypeCountById(activityType);
	}

	@Override
	public int getConds(int id,int activityType) {
		return activitiesMapper.getConds(id,activityType);
	}

	@Override
	public int getBouns(int condId, int activityType) {
		return activitiesMapper.getBouns(condId,activityType);
	}

}