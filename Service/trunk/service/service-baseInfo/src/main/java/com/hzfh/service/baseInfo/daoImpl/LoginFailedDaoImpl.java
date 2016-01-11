package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.model.query.LoginFailedCondition;
import com.hzfh.service.baseInfo.dao.LoginFailedDao;
import com.hzfh.service.baseInfo.mapper.LoginFailedMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("loginFailedDao")
public class LoginFailedDaoImpl extends BaseDaoImpl<LoginFailed, LoginFailedCondition, LoginFailedMapper> implements LoginFailedDao {
}