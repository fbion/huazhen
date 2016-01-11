package com.hzfh.api.customer.service;



import java.util.List;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActivityCashBonusService extends BaseService<ActivityCashBonus, ActivityCashBonusCondition> {

	List<ActivityCashBonus> getActivityCashBonusByActId(int activityId);
}