package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzfh.api.baseInfo.service.SmsService;
import com.hzfh.service.baseInfo.dao.SmsDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("smsService")
public class SmsServiceImpl extends BaseServiceImpl<Sms, SmsCondition, SmsDao> implements SmsService {
    @Autowired
     SmsDao smsDao ;
    @Override
    public String verification(String telephone){
        return smsDao.verification(telephone);
    }
}