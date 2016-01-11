package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
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


public interface ActivitiesService extends BaseService<Activities, ActivitiesCondition> {


	Activities getInfoByActivitytype(int type);


	int updateActivitiesByIdAndStatus(int id, int status);


	int getActivitiesTypeCountById(int activityType);


	int getConds(int id,int activityType);


	int getBouns(int condId, int activityType);

}