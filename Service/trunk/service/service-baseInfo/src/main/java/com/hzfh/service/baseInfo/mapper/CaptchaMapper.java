package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("captchaMapper")
public interface CaptchaMapper extends BaseMapper<Captcha, CaptchaCondition> {

	Captcha selectByIdAndCode(@Param("id")int id,@Param("code") String code);
}