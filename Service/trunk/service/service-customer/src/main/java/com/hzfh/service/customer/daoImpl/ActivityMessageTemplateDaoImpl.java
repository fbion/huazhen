package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityMessageTemplate;
import com.hzfh.api.customer.model.query.ActivityMessageTemplateCondition;
import com.hzfh.service.customer.dao.ActivityMessageTemplateDao;
import com.hzfh.service.customer.mapper.ActivityMessageTemplateMapper;
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


@Service("activityMessageTemplateDao")
public class ActivityMessageTemplateDaoImpl extends BaseDaoImpl<ActivityMessageTemplate, ActivityMessageTemplateCondition, ActivityMessageTemplateMapper> implements ActivityMessageTemplateDao {
}