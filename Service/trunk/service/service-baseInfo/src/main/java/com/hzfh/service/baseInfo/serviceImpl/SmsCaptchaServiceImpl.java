package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.query.SmsCaptchaCondition;
import com.hzfh.api.baseInfo.service.SmsCaptchaService;
import com.hzfh.service.baseInfo.dao.SmsCaptchaDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("smsCaptchaService")
public class SmsCaptchaServiceImpl extends BaseServiceImpl<SmsCaptcha, SmsCaptchaCondition, SmsCaptchaDao> implements SmsCaptchaService {
}