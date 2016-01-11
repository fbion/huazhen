package com.hzfh.service.market.daoImpl;

import java.util.List;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.service.market.dao.WinningRecordDao;
import com.hzfh.service.market.mapper.ActivityUsersMapper;
import com.hzfh.service.market.mapper.WinningRecordMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("winningRecordDao")
public class WinningRecordDaoImpl extends BaseDaoImpl<WinningRecord, WinningRecordCondition, WinningRecordMapper> implements WinningRecordDao {
	@Autowired
	WinningRecordMapper winningRecordMapper;

	@Override
	public List<WinningRecord> getAllWinersByDrawNo(int drawNo) {
		return winningRecordMapper.getAllWinersByDrawNo(drawNo);
	}
	
}