package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface SmsDao extends BaseDao<Sms, SmsCondition> {
    public String verification(String telephone);
}