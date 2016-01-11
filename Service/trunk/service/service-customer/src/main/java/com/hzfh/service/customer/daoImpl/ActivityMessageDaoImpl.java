package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ActivityMessage;
import com.hzfh.api.customer.model.query.ActivityMessageCondition;
import com.hzfh.service.customer.dao.ActivityMessageDao;
import com.hzfh.service.customer.mapper.ActivityMessageMapper;
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


@Service("activityMessageDao")
public class ActivityMessageDaoImpl extends BaseDaoImpl<ActivityMessage, ActivityMessageCondition, ActivityMessageMapper> implements ActivityMessageDao {
}