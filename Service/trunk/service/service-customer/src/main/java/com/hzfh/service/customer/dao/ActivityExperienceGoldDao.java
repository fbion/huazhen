package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
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


public interface ActivityExperienceGoldDao extends BaseDao<ActivityExperienceGold, ActivityExperienceGoldCondition> {

	List<ActivityExperienceGold> getActExperienceGoldModelByActId(int parseInt);
}