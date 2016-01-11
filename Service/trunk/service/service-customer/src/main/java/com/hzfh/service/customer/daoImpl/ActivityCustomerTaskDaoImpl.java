package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
import com.hzfh.service.customer.dao.ActivityCustomerTaskDao;
import com.hzfh.service.customer.mapper.ActivityCustomerTaskMapper;
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


@Service("activityCustomerTaskDao")
public class ActivityCustomerTaskDaoImpl extends BaseDaoImpl<ActivityCustomerTask, ActivityCustomerTaskCondition, ActivityCustomerTaskMapper> implements ActivityCustomerTaskDao {
	@Autowired
	private ActivityCustomerTaskMapper activityCustomerTaskMapper;
	@Override
	public ActivityCustomerTask getInfoByCondition(int customerId,int activityId) {
		return activityCustomerTaskMapper.getInfoByCondition(customerId,activityId);
	}
}