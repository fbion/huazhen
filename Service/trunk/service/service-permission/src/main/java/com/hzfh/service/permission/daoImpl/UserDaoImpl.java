package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzfh.service.permission.dao.UserDao;
import com.hzfh.service.permission.mapper.UserMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, UserCondition, UserMapper> implements UserDao {
	@Autowired
	UserMapper userMapper;
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}
	@Override
	public int updatePwd(int id, String password) {
		return userMapper.updatePwd(id,password);
	}
	@Override
	public String getPwdById(int id) {
		return userMapper.getPwdById(id);
	}
	@Override
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}

	@Override
	public int updateLastLoginById(int id, Timestamp currentTime) {
		return userMapper.updateLastLoginById(id, currentTime);
	}
}