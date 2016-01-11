package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzframework.data.service.BaseService;

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


public interface CaptchaService extends BaseService<Captcha, CaptchaCondition> {

	Captcha selectByIdAndCode(int id, String code);
}