package com.hzfh.service.market.daoImpl;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.service.market.dao.ActivityUsersDao;
import com.hzfh.service.market.mapper.ActivityUsersMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("activityUsersDao")
public class ActivityUsersDaoImpl extends BaseDaoImpl<ActivityUsers, ActivityUsersCondition, ActivityUsersMapper> implements ActivityUsersDao {
	@Autowired
	ActivityUsersMapper activityUsersMapper;
	@Override
	public  List<ActivityUsers> getInfoByUsername(String name) {
		return activityUsersMapper.getInfoByUsername(name);
	}
	@Override
	public List<ActivityUsers> getListByIsWin(int isWin) {
		return activityUsersMapper.getListByIsWin(isWin);
	}
	@Override
	public List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo) {
		return activityUsersMapper.getIntrinsicUsersByDrawNo(drawNo);
	}
	@Override
	public List<ActivityUsers> getOtherWinersByIsWin(int isWin, int otherNum) {
		return activityUsersMapper.getOtherWinersByIsWin(isWin,otherNum);
	}
	@Override
	public List<ActivityUsers> getInfoByUsernameAndIds(String userName,List<Integer> idList,int drawNo) {
		return activityUsersMapper.getInfoByUsernameAndIds(userName,idList,drawNo);
	}
	@Override
	public List<ActivityUsers> getListByIds(String checkValue,List<Integer>  idList,int drawNo) {
		return activityUsersMapper.getListByIds(checkValue,idList,drawNo);
	}

	@Override
	public ActivityUsers getInfoByOpenId(String openid) {
		return activityUsersMapper.getInfoByOpenId(openid);
	}

	@Override
	public List<ActivityUsers> getListByDrawNo(int drawNo) {
		return activityUsersMapper.getListByDrawNo(drawNo);
	}
	@Override
	public List<ActivityUsers> getInfoByUsername(String userName, int drawNo) {
		return activityUsersMapper.getInfoByUsername(userName,drawNo);
	}

}