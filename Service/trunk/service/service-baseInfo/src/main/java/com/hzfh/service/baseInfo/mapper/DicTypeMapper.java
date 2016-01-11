package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("dicTypeMapper")
public interface DicTypeMapper extends BaseMapper<DicType, DicTypeCondition> {
}