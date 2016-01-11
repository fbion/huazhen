package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.service.customer.dao.ActivityRuleRelationDao;
import com.hzfh.service.customer.mapper.ActivityRuleRelationMapper;
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


@Service("activityRuleRelationDao")
public class ActivityRuleRelationDaoImpl extends BaseDaoImpl<ActivityRuleRelation, ActivityRuleRelationCondition, ActivityRuleRelationMapper> implements ActivityRuleRelationDao {
	@Autowired
	private ActivityRuleRelationMapper activityRuleRelationMapper;
	@Override
	public ActivityRuleRelation getInfoByRuleid(int id) {
		return activityRuleRelationMapper.getInfoByRuleid(id);
	}
	@Override
	public List<ActivityRuleRelation> getInfoByActivityNo(int id) {
		return activityRuleRelationMapper.getInfoByActivityNo(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityRuleRelationMapper.deleteInfoByCondId(id);
	}
}