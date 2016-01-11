package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzfh.api.baseInfo.service.CaptchaService;
import com.hzfh.service.baseInfo.dao.CaptchaDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("captchaService")
public class CaptchaServiceImpl extends BaseServiceImpl<Captcha, CaptchaCondition, CaptchaDao> implements CaptchaService {

	@Autowired
	private CaptchaDao captchaDao;
	@Override
	public Captcha selectByIdAndCode(int id, String code) {
		return captchaDao.selectByIdAndCode(id,code);
	}
}