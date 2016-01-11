package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeProduct4;
import com.hzfh.api.baseInfo.model.query.CodeProduct4Condition;
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


@Service("codeProduct4Mapper")
public interface CodeProduct4Mapper extends BaseMapper<CodeProduct4, CodeProduct4Condition> {
}