package com.hzfh.service.market.mapper;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("activityUsersMapper")
public interface ActivityUsersMapper extends BaseMapper<ActivityUsers, ActivityUsersCondition> {

	 List<ActivityUsers> getInfoByUsername(@Param("name") String name);

	List<ActivityUsers> getListByIsWin(int isWin);

	List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo);

	List<ActivityUsers> getOtherWinersByIsWin(@Param("isWin")int isWin, @Param("otherNum")int otherNum);


	List<ActivityUsers> getAllWinersByDrawNo(int drawNo);


	List<ActivityUsers> getInfoByUsernameAndIds(@Param("name")String userName,@Param("idList")List<Integer>  idList,@Param("drawNo")int drawNo);

	List<ActivityUsers> getListByIds(@Param("id")String checkValue,@Param("idList")List<Integer>  idList,@Param("drawNo")int drawNo);


	ActivityUsers getInfoByOpenId(@Param("openid")String openid);

	List<ActivityUsers> getListByDrawNo(@Param("drawNo") int drawNo);

	List<ActivityUsers> getInfoByUsername(@Param("name") String userName, @Param("drawNo") int drawNo);




}