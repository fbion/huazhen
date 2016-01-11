package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
import com.hzfh.service.customer.dao.ActivityCustomerDetailDao;
import com.hzfh.service.customer.mapper.ActivityCustomerDetailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("activityCustomerDetailDao")
public class ActivityCustomerDetailDaoImpl extends BaseDaoImpl<ActivityCustomerDetail, ActivityCustomerDetailCondition, ActivityCustomerDetailMapper> implements ActivityCustomerDetailDao {
	@Autowired
	private ActivityCustomerDetailMapper activityCustomerDetailMapper;

	@Override
	public ActivityCustomerDetail getActivityCustomerDetailById(int activityId) {
		return activityCustomerDetailMapper.getActivityCustomerDetailById(activityId);
	}

}