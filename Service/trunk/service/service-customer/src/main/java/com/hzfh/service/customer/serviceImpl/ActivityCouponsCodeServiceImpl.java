package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCouponsCode;
import com.hzfh.api.customer.model.query.ActivityCouponsCodeCondition;
import com.hzfh.api.customer.service.ActivityCouponsCodeService;
import com.hzfh.service.customer.dao.ActivityCouponsCodeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("activityCouponsCodeService")
public class ActivityCouponsCodeServiceImpl extends BaseServiceImpl<ActivityCouponsCode, ActivityCouponsCodeCondition, ActivityCouponsCodeDao> implements ActivityCouponsCodeService {
}