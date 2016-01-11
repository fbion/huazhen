package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
import com.hzfh.api.customer.service.ActivityExperienceGoldService;
import com.hzfh.service.customer.dao.ActivityExperienceGoldDao;
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


@Service("activityExperienceGoldService")
public class ActivityExperienceGoldServiceImpl extends BaseServiceImpl<ActivityExperienceGold, ActivityExperienceGoldCondition, ActivityExperienceGoldDao> implements ActivityExperienceGoldService {

	@Autowired
	ActivityExperienceGoldDao activityExperienceGoldDao;
	@Override
	public List<ActivityExperienceGold> getActExperienceGoldModelByActId(int parseInt) {
		return activityExperienceGoldDao.getActExperienceGoldModelByActId(parseInt);
	}
}