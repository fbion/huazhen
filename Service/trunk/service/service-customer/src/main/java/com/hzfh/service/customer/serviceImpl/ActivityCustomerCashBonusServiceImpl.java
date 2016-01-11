package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
import com.hzfh.api.customer.service.ActivityCustomerCashBonusService;
import com.hzfh.service.customer.dao.ActivityCustomerCashBonusDao;
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


@Service("activityCustomerCashBonusService")
public class ActivityCustomerCashBonusServiceImpl extends BaseServiceImpl<ActivityCustomerCashBonus, ActivityCustomerCashBonusCondition, ActivityCustomerCashBonusDao> implements ActivityCustomerCashBonusService {
	@Autowired
	private ActivityCustomerCashBonusDao activityCustomerCashBonusDao;
	@Override
	public ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId, int invitedId) {
		return activityCustomerCashBonusDao.getInfoByCustomerIdAndInvitedId(customerId,invitedId);
	}
	@Override
	public int updateStatusById(int id, int status) {
		return activityCustomerCashBonusDao.updateStatusById(id,status);
	}
}