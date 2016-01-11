package com.hzfh.api.market.service;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface ActivityApplyUserService extends BaseService<ActivityApplyUser, ActivityApplyUserCondition> {
	ActivityApplyUser getInfoByCellphone(String cellphone,int id);
}