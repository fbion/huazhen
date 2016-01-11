package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.model.query.LoginFailedCondition;
import com.hzfh.api.baseInfo.service.LoginFailedService;
import com.hzfh.service.baseInfo.dao.LoginFailedDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("loginFailedService")
public class LoginFailedServiceImpl extends BaseServiceImpl<LoginFailed, LoginFailedCondition, LoginFailedDao> implements LoginFailedService {
}