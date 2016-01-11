package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
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


public interface ActivityConditionRelationDao extends BaseDao<ActivityConditionRelation, ActivityConditionRelationCondition> {
	ActivityConditionRelation getInfoByConditionid(int id);

	int deleteInfoByCondId(int id);
}