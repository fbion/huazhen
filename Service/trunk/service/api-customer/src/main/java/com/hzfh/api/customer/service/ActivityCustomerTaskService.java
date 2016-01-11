package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
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


public interface ActivityCustomerTaskService extends BaseService<ActivityCustomerTask, ActivityCustomerTaskCondition> {

	ActivityCustomerTask getInfoByCondition(int customerId, int activityId);
}