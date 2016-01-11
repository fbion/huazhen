package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Other;
import com.hzfh.api.employee.model.query.OtherCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("otherMapper")
public interface OtherMapper extends BaseMapper<Other, OtherCondition> {
}