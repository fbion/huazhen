package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeProduct1;
import com.hzfh.api.baseInfo.model.query.CodeProduct1Condition;
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


@Service("codeProduct1Mapper")
public interface CodeProduct1Mapper extends BaseMapper<CodeProduct1, CodeProduct1Condition> {
}