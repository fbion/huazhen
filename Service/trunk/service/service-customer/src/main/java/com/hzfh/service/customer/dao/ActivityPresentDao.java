package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
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


public interface ActivityPresentDao extends BaseDao<ActivityPresent, ActivityPresentCondition> {

	List<ActivityPresent> getActivityPresentByactId(int activityId);
}