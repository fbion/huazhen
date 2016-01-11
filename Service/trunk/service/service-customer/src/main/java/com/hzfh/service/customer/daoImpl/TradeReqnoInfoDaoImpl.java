package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzfh.service.customer.dao.TradeReqnoInfoDao;
import com.hzfh.service.customer.mapper.TradeReqnoInfoMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/18 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("tradeReqnoInfoDao")
public class TradeReqnoInfoDaoImpl extends BaseDaoImpl<TradeReqnoInfo, TradeReqnoInfoCondition, TradeReqnoInfoMapper> implements TradeReqnoInfoDao {
	@Autowired
	private TradeReqnoInfoMapper tradeReqnoInfoMapper;
	@Override
	public TradeReqnoInfo getInfoBySnAndIsOk(String requestNo, int isOk) {
		return tradeReqnoInfoMapper.getInfoBySnAndIsOk(requestNo,isOk);
	}
}