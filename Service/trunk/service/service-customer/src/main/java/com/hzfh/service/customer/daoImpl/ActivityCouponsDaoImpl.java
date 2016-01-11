package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.query.ActivityCouponsCondition;
import com.hzfh.service.customer.dao.ActivityCouponsDao;
import com.hzfh.service.customer.mapper.ActivityCouponsMapper;
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


@Service("activityCouponsDao")
public class ActivityCouponsDaoImpl extends BaseDaoImpl<ActivityCoupons, ActivityCouponsCondition, ActivityCouponsMapper> implements ActivityCouponsDao {
	@Autowired
	ActivityCouponsMapper activityCouponsMapper;
	@Override
	public List<ActivityCoupons> getActivityCouponsByActId(int activityId) {
		return activityCouponsMapper.getActivityCouponsByActId(activityId);
	}
}