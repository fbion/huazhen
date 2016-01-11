package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmstempleteCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("smstempleteMapper")
public interface SmstempleteMapper extends BaseMapper<Smstemplete, SmstempleteCondition> {
}