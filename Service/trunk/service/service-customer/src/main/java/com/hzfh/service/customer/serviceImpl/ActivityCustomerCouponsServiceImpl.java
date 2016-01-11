package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerCoupons;
import com.hzfh.api.customer.model.query.ActivityCustomerCouponsCondition;
import com.hzfh.api.customer.service.ActivityCustomerCouponsService;
import com.hzfh.service.customer.dao.ActivityCustomerCouponsDao;
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


@Service("activityCustomerCouponsService")
public class ActivityCustomerCouponsServiceImpl extends BaseServiceImpl<ActivityCustomerCoupons, ActivityCustomerCouponsCondition, ActivityCustomerCouponsDao> implements ActivityCustomerCouponsService {
	@Autowired
	ActivityCustomerCouponsDao activityCustomerCouponsDao;

}