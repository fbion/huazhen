package com.hzfh.service.customer.serviceImpl;



import java.util.List;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzfh.api.customer.service.ActivityCashBonusService;
import com.hzfh.service.customer.dao.ActivityCashBonusDao;
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


@Service("activityCashBonusService")
public class ActivityCashBonusServiceImpl extends BaseServiceImpl<ActivityCashBonus, ActivityCashBonusCondition, ActivityCashBonusDao> implements ActivityCashBonusService {
	@Autowired
	private ActivityCashBonusDao activityCashBonusDao;
	@Override
	public List<ActivityCashBonus> getActivityCashBonusByActId(int activityId) {
		// TODO Auto-generated method stub
		return activityCashBonusDao.getActivityCashBonusByActId(activityId);
	}
}