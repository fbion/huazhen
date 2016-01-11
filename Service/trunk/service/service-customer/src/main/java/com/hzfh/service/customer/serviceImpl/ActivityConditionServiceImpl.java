package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.api.customer.service.ActivityConditionService;
import com.hzfh.service.customer.dao.ActivityConditionDao;
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


@Service("activityConditionService")
public class ActivityConditionServiceImpl extends BaseServiceImpl<ActivityCondition, ActivityConditionCondition, ActivityConditionDao> implements ActivityConditionService {
	@Autowired
	ActivityConditionDao activityConditionDao;
	@Override
	public List<Integer> getIds() {
		return activityConditionDao.getIds();
	}
	@Override
	public List<ActivityCondition> getInfoByActId(int id) {
		return activityConditionDao.getInfoByActId(id);
	}
	@Override
	public int getActInfoByAcId(int id) {
		return activityConditionDao.getActInfoByAcId(id);
	}
}