package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityFeedback;
import com.hzfh.api.customer.model.query.ActivityFeedbackCondition;
import com.hzfh.api.customer.service.ActivityFeedbackService;
import com.hzfh.service.customer.dao.ActivityFeedbackDao;
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


@Service("activityFeedbackService")
public class ActivityFeedbackServiceImpl extends BaseServiceImpl<ActivityFeedback, ActivityFeedbackCondition, ActivityFeedbackDao> implements ActivityFeedbackService {
}