package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
import com.hzfh.api.customer.service.ActivityCustomerDetailService;
import com.hzfh.service.customer.dao.ActivityCustomerDetailDao;
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


@Service("activityCustomerDetailService")
public class ActivityCustomerDetailServiceImpl extends BaseServiceImpl<ActivityCustomerDetail, ActivityCustomerDetailCondition, ActivityCustomerDetailDao> implements ActivityCustomerDetailService {
	@Autowired
	private ActivityCustomerDetailDao activityCustomerDetailDao;
	@Override
	public ActivityCustomerDetail getActivityCustomerDetailById(int activityId) {
		// TODO Auto-generated method stub
		return activityCustomerDetailDao.getActivityCustomerDetailById(activityId);
	}
}