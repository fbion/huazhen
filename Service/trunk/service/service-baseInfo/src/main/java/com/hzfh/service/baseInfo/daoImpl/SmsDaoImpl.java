package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzfh.service.baseInfo.dao.SmsDao;
import com.hzfh.service.baseInfo.mapper.SmsMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("smsDao")
public class SmsDaoImpl extends BaseDaoImpl<Sms, SmsCondition, SmsMapper> implements SmsDao {
    @Autowired
    SmsMapper smsMapper;
    @Override
    public String verification(String telephone){
        return smsMapper.verification(telephone);
    }
}