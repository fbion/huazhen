package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzfh.service.baseInfo.dao.SnDao;
import com.hzfh.service.baseInfo.mapper.SnMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("snDao")
public class SnDaoImpl extends BaseDaoImpl<Sn, SnCondition, SnMapper> implements SnDao {

	@Autowired
	private SnMapper snMapper;
	
	@Override
	public void truncateSn() {
		snMapper.truncateSn();
	}
}