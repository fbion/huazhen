package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
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


public interface ActivityConditionRelationService extends BaseService<ActivityConditionRelation, ActivityConditionRelationCondition> {
	ActivityConditionRelation getInfoByConditionid(int id);

	int deleteInfoByCondId(int id);
}