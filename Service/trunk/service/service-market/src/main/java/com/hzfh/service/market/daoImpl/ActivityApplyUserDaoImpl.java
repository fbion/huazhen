package com.hzfh.service.market.daoImpl;


import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.service.market.dao.ActivityApplyUserDao;
import com.hzfh.service.market.mapper.ActivityApplyUserMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("activityApplyUserDao")
public class ActivityApplyUserDaoImpl extends BaseDaoImpl<ActivityApplyUser, ActivityApplyUserCondition, ActivityApplyUserMapper> implements ActivityApplyUserDao {
	@Autowired 
	ActivityApplyUserMapper activityApplyUserMapper;
	public ActivityApplyUser getInfoByCellphone(String cellphone,int id){
		return activityApplyUserMapper.getInfoByCellphone(cellphone,id);
	}
}