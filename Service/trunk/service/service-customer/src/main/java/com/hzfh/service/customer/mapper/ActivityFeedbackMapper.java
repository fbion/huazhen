package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityFeedback;
import com.hzfh.api.customer.model.query.ActivityFeedbackCondition;
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


@Service("activityFeedbackMapper")
public interface ActivityFeedbackMapper extends BaseMapper<ActivityFeedback, ActivityFeedbackCondition> {
}