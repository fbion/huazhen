package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ActivityMessageTemplate;
import com.hzfh.api.customer.model.query.ActivityMessageTemplateCondition;
import com.hzfh.api.customer.service.ActivityMessageTemplateService;
import com.hzfh.service.customer.dao.ActivityMessageTemplateDao;
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


@Service("activityMessageTemplateService")
public class ActivityMessageTemplateServiceImpl extends BaseServiceImpl<ActivityMessageTemplate, ActivityMessageTemplateCondition, ActivityMessageTemplateDao> implements ActivityMessageTemplateService {
}