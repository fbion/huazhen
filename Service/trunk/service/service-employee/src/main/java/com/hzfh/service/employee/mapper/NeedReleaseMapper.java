package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/25 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("needReleaseMapper")
public interface NeedReleaseMapper extends BaseMapper<NeedRelease, NeedReleaseCondition> {
}