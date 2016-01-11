package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeAgent;
import com.hzfh.api.baseInfo.model.query.CodeAgentCondition;
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


@Service("codeAgentMapper")
public interface CodeAgentMapper extends BaseMapper<CodeAgent, CodeAgentCondition> {
}