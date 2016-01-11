package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityFeedback;
import com.hzfh.api.customer.model.query.ActivityFeedbackCondition;
import com.hzfh.service.customer.dao.ActivityFeedbackDao;
import com.hzfh.service.customer.mapper.ActivityFeedbackMapper;
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


@Service("activityFeedbackDao")
public class ActivityFeedbackDaoImpl extends BaseDaoImpl<ActivityFeedback, ActivityFeedbackCondition, ActivityFeedbackMapper> implements ActivityFeedbackDao {
}