package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeProduct2;
import com.hzfh.api.baseInfo.model.query.CodeProduct2Condition;
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


@Service("codeProduct2Mapper")
public interface CodeProduct2Mapper extends BaseMapper<CodeProduct2, CodeProduct2Condition> {
}