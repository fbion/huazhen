package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.service.customer.dao.ActivityCouponsProductDao;
import com.hzfh.service.customer.mapper.ActivityCouponsProductMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("activityCouponsProductDao")
public class ActivityCouponsProductDaoImpl extends BaseDaoImpl<ActivityCouponsProduct, ActivityCouponsProductCondition, ActivityCouponsProductMapper> implements ActivityCouponsProductDao {
}