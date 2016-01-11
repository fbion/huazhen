package com.hzfh.service.market.mapper;

import java.util.List;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/4 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("winningRecordMapper")
public interface WinningRecordMapper extends BaseMapper<WinningRecord, WinningRecordCondition> {

	List<WinningRecord> getAllWinersByDrawNo(int drawNo);
}