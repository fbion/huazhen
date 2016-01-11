package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActivityRuleRelationService extends BaseService<ActivityRuleRelation, ActivityRuleRelationCondition> {
	ActivityRuleRelation getInfoByRuleid(int id);
	List<ActivityRuleRelation> getInfoByActivityNo(int id);
	int deleteInfoByCondId(int id);
}