package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.query.ActivityIntegralDetailCondition;
import com.hzfh.service.customer.dao.ActivityIntegralDetailDao;
import com.hzfh.service.customer.mapper.ActivityIntegralDetailMapper;
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


@Service("activityIntegralDetailDao")
public class ActivityIntegralDetailDaoImpl extends BaseDaoImpl<ActivityIntegralDetail, ActivityIntegralDetailCondition, ActivityIntegralDetailMapper> implements ActivityIntegralDetailDao {
}