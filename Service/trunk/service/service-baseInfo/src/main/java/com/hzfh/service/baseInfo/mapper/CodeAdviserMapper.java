package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.api.baseInfo.model.query.CodeAdviserCondition;
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


@Service("codeAdviserMapper")
public interface CodeAdviserMapper extends BaseMapper<CodeAdviser, CodeAdviserCondition> {
}