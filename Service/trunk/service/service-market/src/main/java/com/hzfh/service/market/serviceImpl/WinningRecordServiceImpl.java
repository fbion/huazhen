package com.hzfh.service.market.serviceImpl;

import java.util.List;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.api.market.service.WinningRecordService;
import com.hzfh.service.market.dao.ActivityUsersDao;
import com.hzfh.service.market.dao.WinningRecordDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("winningRecordService")
public class WinningRecordServiceImpl extends BaseServiceImpl<WinningRecord, WinningRecordCondition, WinningRecordDao> implements WinningRecordService {

	@Autowired
	WinningRecordDao winningRecordDao; 
	@Override
	public List<WinningRecord> getAllWinersByDrawNo(int drawNo) {
		return winningRecordDao.getAllWinersByDrawNo(drawNo);
	}
}