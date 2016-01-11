package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.query.EmailCondition;
import com.hzfh.api.baseInfo.service.EmailService;
import com.hzfh.service.baseInfo.dao.EmailDao;
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


@Service("emailService")
public class EmailServiceImpl extends BaseServiceImpl<Email, EmailCondition, EmailDao> implements EmailService {
}