package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.query.ActivityCouponsCondition;
import com.hzfh.api.customer.service.ActivityCouponsService;
import com.hzfh.service.customer.dao.ActivityCouponsDao;
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


@Service("activityCouponsService")
public class ActivityCouponsServiceImpl extends BaseServiceImpl<ActivityCoupons, ActivityCouponsCondition, ActivityCouponsDao> implements ActivityCouponsService {
	@Autowired
	ActivityCouponsDao activityCouponsDao;
	@Override
	public List<ActivityCoupons> getActivityCouponsByActId(int activityId) {
		return activityCouponsDao.getActivityCouponsByActId(activityId);
	}
}