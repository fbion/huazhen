package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.service.customer.dao.ActivityMessageStatusDao;
import com.hzfh.service.customer.mapper.ActivityMessageStatusMapper;
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


@Service("activityMessageStatusDao")
public class ActivityMessageStatusDaoImpl extends BaseDaoImpl<ActivityMessageStatus, ActivityMessageStatusCondition, ActivityMessageStatusMapper> implements ActivityMessageStatusDao {
}