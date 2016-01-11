package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.api.customer.service.ActivityRuleRelationService;
import com.hzfh.service.customer.dao.ActivityRuleRelationDao;
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


@Service("activityRuleRelationService")
public class ActivityRuleRelationServiceImpl extends BaseServiceImpl<ActivityRuleRelation, ActivityRuleRelationCondition, ActivityRuleRelationDao> implements ActivityRuleRelationService {
	@Autowired
	private ActivityRuleRelationDao activityRuleRelationDao;
	@Override
	public ActivityRuleRelation getInfoByRuleid(int id) {
		return activityRuleRelationDao.getInfoByRuleid(id);
	}
	@Override
	public List<ActivityRuleRelation> getInfoByActivityNo(int id) {
		return activityRuleRelationDao.getInfoByActivityNo(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityRuleRelationDao.deleteInfoByCondId(id);
	}
}