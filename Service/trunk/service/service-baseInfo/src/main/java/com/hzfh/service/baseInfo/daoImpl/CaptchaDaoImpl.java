package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzfh.service.baseInfo.dao.CaptchaDao;
import com.hzfh.service.baseInfo.mapper.CaptchaMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("captchaDao")
public class CaptchaDaoImpl extends BaseDaoImpl<Captcha, CaptchaCondition, CaptchaMapper> implements CaptchaDao {

	@Autowired
	private CaptchaMapper captchaMapper;
	@Override
	public Captcha selectByIdAndCode(int id, String code) {
		return captchaMapper.selectByIdAndCode(id,code);
	}
}