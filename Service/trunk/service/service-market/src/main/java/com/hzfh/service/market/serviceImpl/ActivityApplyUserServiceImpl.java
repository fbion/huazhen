package com.hzfh.service.market.serviceImpl;


import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.api.market.service.ActivityApplyUserService;
import com.hzfh.service.market.dao.ActivityApplyUserDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("activityApplyUserService")
public class ActivityApplyUserServiceImpl extends BaseServiceImpl<ActivityApplyUser, ActivityApplyUserCondition, ActivityApplyUserDao> implements ActivityApplyUserService {
	@Autowired
	ActivityApplyUserDao activityApplyUserDao;
	
	public ActivityApplyUser getInfoByCellphone(String cellphone,int id){
		return activityApplyUserDao.getInfoByCellphone(cellphone,id);
	}
}