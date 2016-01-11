package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2014 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2014/12/29
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


@Service("userMapper")
public interface UserMapper extends BaseMapper<User, UserCondition> {

    User login(User user);

    int updatePwd(int id, String password);

    String getPwdById(int id);

    User getUserByUserName(String userName);

    int updateLastLoginById(@Param("id")int id, @Param("currentTime")Timestamp currentTime);
}