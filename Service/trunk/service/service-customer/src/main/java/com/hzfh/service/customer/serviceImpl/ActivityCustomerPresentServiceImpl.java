package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzfh.api.customer.service.ActivityCustomerPresentService;
import com.hzfh.service.customer.dao.ActivityCustomerPresentDao;
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


@Service("activityCustomerPresentService")
public class ActivityCustomerPresentServiceImpl extends BaseServiceImpl<ActivityCustomerPresent, ActivityCustomerPresentCondition, ActivityCustomerPresentDao> implements ActivityCustomerPresentService {
}