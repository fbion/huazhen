package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ChangeManagerLog;
import com.hzfh.api.customer.model.query.ChangeManagerLogCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("changeManagerLogMapper")
public interface ChangeManagerLogMapper extends BaseMapper<ChangeManagerLog, ChangeManagerLogCondition> {
}