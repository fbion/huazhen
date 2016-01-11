package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
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


public interface ActivityConditionService extends BaseService<ActivityCondition, ActivityConditionCondition> {
	List<Integer> getIds();

	List<ActivityCondition> getInfoByActId(int id);

	int getActInfoByAcId(int id);
}