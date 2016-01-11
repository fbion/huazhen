package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzfh.api.customer.service.TradeReqnoInfoService;
import com.hzfh.service.customer.dao.TradeReqnoInfoDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("tradeReqnoInfoService")
public class TradeReqnoInfoServiceImpl extends BaseServiceImpl<TradeReqnoInfo, TradeReqnoInfoCondition, TradeReqnoInfoDao> implements TradeReqnoInfoService {
	@Autowired
	private TradeReqnoInfoDao tradeReqnoInfoDao;
	@Override
	public TradeReqnoInfo getInfoBySnAndIsOk(String requestNo, int isOk) {
		return tradeReqnoInfoDao.getInfoBySnAndIsOk(requestNo,isOk);
	}
}