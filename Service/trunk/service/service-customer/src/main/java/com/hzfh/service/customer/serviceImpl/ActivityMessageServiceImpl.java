package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityMessage;
import com.hzfh.api.customer.model.query.ActivityMessageCondition;
import com.hzfh.api.customer.service.ActivityMessageService;
import com.hzfh.service.customer.dao.ActivityMessageDao;
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


@Service("activityMessageService")
public class ActivityMessageServiceImpl extends BaseServiceImpl<ActivityMessage, ActivityMessageCondition, ActivityMessageDao> implements ActivityMessageService {
}