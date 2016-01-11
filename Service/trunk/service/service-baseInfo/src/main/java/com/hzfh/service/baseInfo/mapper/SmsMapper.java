package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("smsMapper")
public interface SmsMapper extends BaseMapper<Sms, SmsCondition> {
    public String verification(@Param("telephone")String telephone);
}