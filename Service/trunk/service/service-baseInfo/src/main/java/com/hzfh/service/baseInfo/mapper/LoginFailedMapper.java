package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.model.query.LoginFailedCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("loginFailedMapper")
public interface LoginFailedMapper extends BaseMapper<LoginFailed, LoginFailedCondition> {
}