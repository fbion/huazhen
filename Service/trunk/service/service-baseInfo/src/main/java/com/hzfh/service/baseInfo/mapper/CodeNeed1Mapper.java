package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeNeed1;
import com.hzfh.api.baseInfo.model.query.CodeNeed1Condition;
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


@Service("codeNeed1Mapper")
public interface CodeNeed1Mapper extends BaseMapper<CodeNeed1, CodeNeed1Condition> {
}