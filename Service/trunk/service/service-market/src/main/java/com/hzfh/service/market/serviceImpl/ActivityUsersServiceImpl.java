package com.hzfh.service.market.serviceImpl;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.api.market.service.ActivityUsersService;
import com.hzfh.service.market.dao.ActivityUsersDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/4 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityUsersService")
public class ActivityUsersServiceImpl extends BaseServiceImpl<ActivityUsers, ActivityUsersCondition, ActivityUsersDao> implements ActivityUsersService {
	@Autowired
	ActivityUsersDao activityUsersDao;
	@Override
	public  List<ActivityUsers> getInfoByUsername(String name) {
		return activityUsersDao.getInfoByUsername(name);
	}
	@Override
	public List<ActivityUsers> getListByIsWin(int isWin) {
		return activityUsersDao.getListByIsWin(isWin);
	}
	@Override
	public List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo) {
		return activityUsersDao.getIntrinsicUsersByDrawNo(drawNo);
	}
	@Override
	public List<ActivityUsers> getOtherWinersByIsWin(int isWin, int otherNum) {
		return activityUsersDao.getOtherWinersByIsWin(isWin,otherNum);
	}
	@Override
	public List<ActivityUsers> getInfoByUsernameAndIds(String userName,
			List<Integer>  idList,int drawNo) {
		return activityUsersDao.getInfoByUsernameAndIds(userName,idList,drawNo);
	}
	@Override
	public List<ActivityUsers> getListByIds(String checkValue,List<Integer>  idList,int drawNo) {
		return activityUsersDao.getListByIds(checkValue,idList,drawNo);
	}

	@Override
	public ActivityUsers getInfoByOpenId(String openid) {
		return activityUsersDao.getInfoByOpenId(openid);
	}

	@Override
	public List<ActivityUsers> getListByDrawNo(int drawNo) {
		return activityUsersDao.getListByDrawNo(drawNo);
	}
	@Override
	public List<ActivityUsers> getInfoByUsername(String userName, int drawNo) {
		return activityUsersDao.getInfoByUsername(userName,drawNo);
	}

}