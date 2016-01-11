package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeCus1;
import com.hzfh.api.baseInfo.model.query.CodeCus1Condition;
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


@Service("codeCus1Mapper")
public interface CodeCus1Mapper extends BaseMapper<CodeCus1, CodeCus1Condition> {
}