package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ActivityRuleRelationDao extends BaseDao<ActivityRuleRelation, ActivityRuleRelationCondition> {
	public ActivityRuleRelation getInfoByRuleid (int id);

	public List<ActivityRuleRelation> getInfoByActivityNo(int id);

	public int deleteInfoByCondId(int id);
}