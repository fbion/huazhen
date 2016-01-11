package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzfh.api.permission.service.UserService;
import com.hzfh.service.permission.dao.UserDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserCondition, UserDao> implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	@Override
	public int updatePwd(int id, String password) {
		return userDao.updatePwd(id,password);
	}
	@Override
	public String getPwdById(int id) {
		return userDao.getPwdById(id);
	}
	@Override
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	@Override
	public int updateLastLoginById(int id, Timestamp currentTime) {
		return userDao.updateLastLoginById(id, currentTime);
	}
}