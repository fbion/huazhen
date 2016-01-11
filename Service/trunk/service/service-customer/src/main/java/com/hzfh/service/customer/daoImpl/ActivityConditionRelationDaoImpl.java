package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.service.customer.dao.ActivityConditionRelationDao;
import com.hzfh.service.customer.mapper.ActivityConditionRelationMapper;
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


@Service("activityConditionRelationDao")
public class ActivityConditionRelationDaoImpl extends BaseDaoImpl<ActivityConditionRelation, ActivityConditionRelationCondition, ActivityConditionRelationMapper> implements ActivityConditionRelationDao {

	@Autowired
	private ActivityConditionRelationMapper activityConditionRelationMapper;
	@Override
	public ActivityConditionRelation getInfoByConditionid(int id) {
		return activityConditionRelationMapper.getInfoByConditionid(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityConditionRelationMapper.deleteInfoByCondId(id);
	}
}