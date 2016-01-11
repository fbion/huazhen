package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.api.customer.service.ActivityCouponsProductService;
import com.hzfh.service.customer.dao.ActivityCouponsProductDao;
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


@Service("activityCouponsProductService")
public class ActivityCouponsProductServiceImpl extends BaseServiceImpl<ActivityCouponsProduct, ActivityCouponsProductCondition, ActivityCouponsProductDao> implements ActivityCouponsProductService {
}