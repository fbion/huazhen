package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface CaptchaDao extends BaseDao<Captcha, CaptchaCondition> {

	Captcha selectByIdAndCode(int id, String code);
}