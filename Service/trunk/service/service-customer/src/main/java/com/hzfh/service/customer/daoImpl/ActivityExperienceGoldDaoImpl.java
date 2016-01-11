package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
import com.hzfh.service.customer.dao.ActivityExperienceGoldDao;
import com.hzfh.service.customer.mapper.ActivityExperienceGoldMapper;
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


@Service("activityExperienceGoldDao")
public class ActivityExperienceGoldDaoImpl extends BaseDaoImpl<ActivityExperienceGold, ActivityExperienceGoldCondition, ActivityExperienceGoldMapper> implements ActivityExperienceGoldDao {
	@Autowired
	ActivityExperienceGoldMapper activityExperienceGoldMapper;
	@Override
	public List<ActivityExperienceGold> getActExperienceGoldModelByActId(int parseInt) {
		return activityExperienceGoldMapper.getActExperienceGoldModelByActId(parseInt);
	}
}