package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("snMapper")
public interface SnMapper extends BaseMapper<Sn, SnCondition> {

	void truncateSn();
}