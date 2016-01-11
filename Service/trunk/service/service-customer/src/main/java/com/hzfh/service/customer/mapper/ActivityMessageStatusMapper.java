package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
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


@Service("activityMessageStatusMapper")
public interface ActivityMessageStatusMapper extends BaseMapper<ActivityMessageStatus, ActivityMessageStatusCondition> {
}