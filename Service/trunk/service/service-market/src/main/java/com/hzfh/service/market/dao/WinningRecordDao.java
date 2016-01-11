package com.hzfh.service.market.dao;

import java.util.List;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface WinningRecordDao extends BaseDao<WinningRecord, WinningRecordCondition> {

	List<WinningRecord> getAllWinersByDrawNo(int drawNo);
}