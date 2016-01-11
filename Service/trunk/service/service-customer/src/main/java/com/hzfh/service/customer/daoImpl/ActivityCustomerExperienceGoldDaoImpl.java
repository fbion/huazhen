package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.service.customer.dao.ActivityCustomerExperienceGoldDao;
import com.hzfh.service.customer.mapper.ActivityCustomerExperienceGoldMapper;
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


@Service("activityCustomerExperienceGoldDao")
public class ActivityCustomerExperienceGoldDaoImpl extends BaseDaoImpl<ActivityCustomerExperienceGold, ActivityCustomerExperienceGoldCondition, ActivityCustomerExperienceGoldMapper> implements ActivityCustomerExperienceGoldDao {
	@Autowired
	private ActivityCustomerExperienceGoldMapper activityCustomerExperienceGoldMapper;
	@Override
	public int updateStatusById(int id, byte status) {
		return activityCustomerExperienceGoldMapper.updateStatusById(id,status);
	}
}