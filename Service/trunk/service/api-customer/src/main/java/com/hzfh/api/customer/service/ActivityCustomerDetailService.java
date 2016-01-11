package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
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


public interface ActivityCustomerDetailService extends BaseService<ActivityCustomerDetail, ActivityCustomerDetailCondition> {

	ActivityCustomerDetail getActivityCustomerDetailById(int activityId);
}