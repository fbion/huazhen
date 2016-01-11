package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodePact;
import com.hzfh.api.baseInfo.model.query.CodePactCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/9 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("codePactMapper")
public interface CodePactMapper extends BaseMapper<CodePact, CodePactCondition> {
}