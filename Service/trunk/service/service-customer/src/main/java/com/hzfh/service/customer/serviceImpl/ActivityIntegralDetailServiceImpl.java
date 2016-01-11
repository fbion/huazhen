package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.query.ActivityIntegralDetailCondition;
import com.hzfh.api.customer.service.ActivityIntegralDetailService;
import com.hzfh.service.customer.dao.ActivityIntegralDetailDao;
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


@Service("activityIntegralDetailService")
public class ActivityIntegralDetailServiceImpl extends BaseServiceImpl<ActivityIntegralDetail, ActivityIntegralDetailCondition, ActivityIntegralDetailDao> implements ActivityIntegralDetailService {
}