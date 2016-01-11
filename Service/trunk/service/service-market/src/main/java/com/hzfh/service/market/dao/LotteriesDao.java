package com.hzfh.service.market.dao;

import java.util.List;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.model.query.LotteriesCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface LotteriesDao extends BaseDao<Lotteries, LotteriesCondition> {

	Lotteries getLotteriesByRand();

	int updateOpenIdById(String openId, int id);

	Lotteries getLotteriesByOpenId(String openId);

	List<Lotteries> getLotteriesListByHasOpenId();
}