package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeProduct3;
import com.hzfh.api.baseInfo.model.query.CodeProduct3Condition;
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


@Service("codeProduct3Mapper")
public interface CodeProduct3Mapper extends BaseMapper<CodeProduct3, CodeProduct3Condition> {
}