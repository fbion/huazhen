package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("activityCustomerPresentMapper")
public interface ActivityCustomerPresentMapper extends BaseMapper<ActivityCustomerPresent, ActivityCustomerPresentCondition> {
}