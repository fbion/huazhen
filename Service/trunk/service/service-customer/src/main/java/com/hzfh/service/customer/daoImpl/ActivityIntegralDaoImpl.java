package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.query.ActivityIntegralCondition;
import com.hzfh.service.customer.dao.ActivityIntegralDao;
import com.hzfh.service.customer.mapper.ActivityIntegralMapper;
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


@Service("activityIntegralDao")
public class ActivityIntegralDaoImpl extends BaseDaoImpl<ActivityIntegral, ActivityIntegralCondition, ActivityIntegralMapper> implements ActivityIntegralDao {

	@Autowired
	ActivityIntegralMapper activityIntegralMapper;
	@Override
	public List<ActivityIntegral> getActivityIntegralByActid(int activityId) {
		return activityIntegralMapper.getActivityIntegralByActid(activityId);
	}
}