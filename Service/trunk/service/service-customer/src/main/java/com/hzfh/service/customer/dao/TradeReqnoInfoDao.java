package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface TradeReqnoInfoDao extends BaseDao<TradeReqnoInfo, TradeReqnoInfoCondition> {

	TradeReqnoInfo getInfoBySnAndIsOk(String requestNo, int isOk);
}