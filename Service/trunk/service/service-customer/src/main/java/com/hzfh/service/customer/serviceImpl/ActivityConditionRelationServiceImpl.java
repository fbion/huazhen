package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.api.customer.service.ActivityConditionRelationService;
import com.hzfh.service.customer.dao.ActivityConditionRelationDao;
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


@Service("activityConditionRelationService")
public class ActivityConditionRelationServiceImpl extends BaseServiceImpl<ActivityConditionRelation, ActivityConditionRelationCondition, ActivityConditionRelationDao> implements ActivityConditionRelationService {

	@Autowired
	private ActivityConditionRelationDao activityConditionRelationDao;
	@Override
	public ActivityConditionRelation getInfoByConditionid(int id) {
		return activityConditionRelationDao.getInfoByConditionid(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityConditionRelationDao.deleteInfoByCondId(id);
	}
}