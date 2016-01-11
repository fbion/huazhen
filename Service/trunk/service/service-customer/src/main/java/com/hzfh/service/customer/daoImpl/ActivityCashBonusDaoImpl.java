package com.hzfh.service.customer.daoImpl;



import java.util.List;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzfh.service.customer.dao.ActivityCashBonusDao;
import com.hzfh.service.customer.mapper.ActivityCashBonusMapper;
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


@Service("activityCashBonusDao")
public class ActivityCashBonusDaoImpl extends BaseDaoImpl<ActivityCashBonus, ActivityCashBonusCondition, ActivityCashBonusMapper> implements ActivityCashBonusDao {
	@Autowired
	private ActivityCashBonusMapper activityCashBonusMapper;
	@Override
	public List<ActivityCashBonus> getActivityCashBonusByActId(int activityId) {
		// TODO Auto-generated method stub
		return activityCashBonusMapper.getActivityCashBonusByActId(activityId);
	}
}