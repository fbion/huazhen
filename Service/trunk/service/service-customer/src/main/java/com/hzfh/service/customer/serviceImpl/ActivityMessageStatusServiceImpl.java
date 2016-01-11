package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.api.customer.service.ActivityMessageStatusService;
import com.hzfh.service.customer.dao.ActivityMessageStatusDao;
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


@Service("activityMessageStatusService")
public class ActivityMessageStatusServiceImpl extends BaseServiceImpl<ActivityMessageStatus, ActivityMessageStatusCondition, ActivityMessageStatusDao> implements ActivityMessageStatusService {
}