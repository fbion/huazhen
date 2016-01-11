package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.query.SmsCaptchaCondition;
import com.hzfh.service.baseInfo.dao.SmsCaptchaDao;
import com.hzfh.service.baseInfo.mapper.SmsCaptchaMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("smsCaptchaDao")
public class SmsCaptchaDaoImpl extends BaseDaoImpl<SmsCaptcha, SmsCaptchaCondition, SmsCaptchaMapper> implements SmsCaptchaDao {
}