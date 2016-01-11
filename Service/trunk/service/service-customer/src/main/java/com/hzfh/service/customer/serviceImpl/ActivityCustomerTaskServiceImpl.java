package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
import com.hzfh.api.customer.service.ActivityCustomerTaskService;
import com.hzfh.service.customer.dao.ActivityCustomerTaskDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("activityCustomerTaskService")
public class ActivityCustomerTaskServiceImpl extends BaseServiceImpl<ActivityCustomerTask, ActivityCustomerTaskCondition, ActivityCustomerTaskDao> implements ActivityCustomerTaskService {

	@Autowired
	private ActivityCustomerTaskDao activityCustomerTaskDao;
	@Override
	public ActivityCustomerTask getInfoByCondition(int customerId,int activityId) {
		return activityCustomerTaskDao.getInfoByCondition(customerId,activityId);
	}
}