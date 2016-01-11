package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzfh.service.customer.dao.ActivityCustomerPresentDao;
import com.hzfh.service.customer.mapper.ActivityCustomerPresentMapper;
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


@Service("activityCustomerPresentDao")
public class ActivityCustomerPresentDaoImpl extends BaseDaoImpl<ActivityCustomerPresent, ActivityCustomerPresentCondition, ActivityCustomerPresentMapper> implements ActivityCustomerPresentDao {
}