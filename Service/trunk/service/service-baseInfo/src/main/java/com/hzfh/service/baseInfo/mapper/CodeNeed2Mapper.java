package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeNeed2;
import com.hzfh.api.baseInfo.model.query.CodeNeed2Condition;
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


@Service("codeNeed2Mapper")
public interface CodeNeed2Mapper extends BaseMapper<CodeNeed2, CodeNeed2Condition> {
}