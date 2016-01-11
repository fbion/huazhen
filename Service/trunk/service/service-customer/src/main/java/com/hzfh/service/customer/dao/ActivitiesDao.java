package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
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


public interface ActivitiesDao extends BaseDao<Activities, ActivitiesCondition> {

	public Activities getInfoByActivitytype(int type);


	int updateActivitiesByIdAndStatus(int id, int status);


	public int getActivitiesTypeCountById(int activityType);


	public int getConds(int id,int activityType);


	public int getBouns(int condId, int activityType);

}