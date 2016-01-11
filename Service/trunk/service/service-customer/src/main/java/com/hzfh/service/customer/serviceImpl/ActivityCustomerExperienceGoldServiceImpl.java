package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.api.customer.service.ActivityCustomerExperienceGoldService;
import com.hzfh.service.customer.dao.ActivityCustomerExperienceGoldDao;
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


@Service("activityCustomerExperienceGoldService")
public class ActivityCustomerExperienceGoldServiceImpl extends BaseServiceImpl<ActivityCustomerExperienceGold, ActivityCustomerExperienceGoldCondition, ActivityCustomerExperienceGoldDao> implements ActivityCustomerExperienceGoldService {
	@Autowired
	private ActivityCustomerExperienceGoldDao activityCustomerExperienceGoldDao;
	@Override
	public int updateStatusById(int id, byte status) {
		return activityCustomerExperienceGoldDao.updateStatusById(id,status);
	}
}