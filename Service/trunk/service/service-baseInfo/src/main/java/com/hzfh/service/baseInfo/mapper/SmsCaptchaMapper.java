package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.query.SmsCaptchaCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/3 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("smsCaptchaMapper")
public interface SmsCaptchaMapper extends BaseMapper<SmsCaptcha, SmsCaptchaCondition> {
}