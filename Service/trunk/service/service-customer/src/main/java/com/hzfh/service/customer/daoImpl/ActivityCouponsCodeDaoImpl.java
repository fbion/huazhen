package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCouponsCode;
import com.hzfh.api.customer.model.query.ActivityCouponsCodeCondition;
import com.hzfh.service.customer.dao.ActivityCouponsCodeDao;
import com.hzfh.service.customer.mapper.ActivityCouponsCodeMapper;
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


@Service("activityCouponsCodeDao")
public class ActivityCouponsCodeDaoImpl extends BaseDaoImpl<ActivityCouponsCode, ActivityCouponsCodeCondition, ActivityCouponsCodeMapper> implements ActivityCouponsCodeDao {
}