package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.query.ActivityIntegralCondition;
import com.hzfh.api.customer.service.ActivityIntegralService;
import com.hzfh.service.customer.dao.ActivityIntegralDao;
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


@Service("activityIntegralService")
public class ActivityIntegralServiceImpl extends BaseServiceImpl<ActivityIntegral, ActivityIntegralCondition, ActivityIntegralDao> implements ActivityIntegralService {
	@Autowired
	ActivityIntegralDao activityIntegralDao;
	@Override
	public List<ActivityIntegral> getActivityIntegralByActid(int activityId) {
		return activityIntegralDao.getActivityIntegralByActid(activityId);
	}
}