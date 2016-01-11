package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzframework.data.service.BaseService;

import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface UserService extends BaseService<User, UserCondition> {
	public User login(User user);
	public int updatePwd(int id, String password);
	public String getPwdById(int id);
	public User getUserByUserName(String userName);
	int updateLastLoginById(int id, Timestamp currentTime);
}