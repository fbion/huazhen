package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
import com.hzfh.service.customer.dao.ActivityCustomerCashBonusDao;
import com.hzfh.service.customer.mapper.ActivityCustomerCashBonusMapper;
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


@Service("activityCustomerCashBonusDao")
public class ActivityCustomerCashBonusDaoImpl extends BaseDaoImpl<ActivityCustomerCashBonus, ActivityCustomerCashBonusCondition, ActivityCustomerCashBonusMapper> implements ActivityCustomerCashBonusDao {

	@Autowired
	private ActivityCustomerCashBonusMapper activityCustomerCashBonusMapper;
	@Override
	public ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId, int invitedId) {
		// TODO Auto-generated method stub
		return activityCustomerCashBonusMapper.getInfoByCustomerIdAndInvitedId(customerId,invitedId);
	}

	@Override
	public int updateStatusById(int id, int status) {
		return activityCustomerCashBonusMapper.updateStatusById(id, status);
	}

}