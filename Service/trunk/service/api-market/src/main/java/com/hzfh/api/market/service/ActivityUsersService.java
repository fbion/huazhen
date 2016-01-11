package com.hzfh.api.market.service;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActivityUsersService extends BaseService<ActivityUsers, ActivityUsersCondition> {

	 List<ActivityUsers> getInfoByUsername(String name);

	List<ActivityUsers> getListByIsWin(int isWin);

	List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo);

	List<ActivityUsers> getOtherWinersByIsWin(int isWin, int otherNum);

	List<ActivityUsers> getInfoByUsernameAndIds(String userName,List<Integer> idList,int drawNo);

	List<ActivityUsers> getListByIds(String checkValue,List<Integer>  idList,int drawNo);

	List<ActivityUsers> getListByDrawNo(int drawNo);

	List<ActivityUsers> getInfoByUsername(String userName, int drawNo);

	ActivityUsers getInfoByOpenId(String openid);
}