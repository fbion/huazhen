package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Welfare;
import com.hzfh.api.employee.model.query.WelfareCondition;
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


@Service("welfareMapper")
public interface WelfareMapper extends BaseMapper<Welfare, WelfareCondition> {
}