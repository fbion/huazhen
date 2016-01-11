package com.hzfh.service.market.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.model.query.LotteriesCondition;
import com.hzfh.api.market.service.LotteriesService;
import com.hzfh.service.market.dao.LotteriesDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("lotteriesService")
public class LotteriesServiceImpl extends BaseServiceImpl<Lotteries, LotteriesCondition, LotteriesDao> implements LotteriesService {

	@Autowired
	private LotteriesDao lotteriesDao;
	@Override
	public Lotteries getLotteriesByRand() {
		return lotteriesDao.getLotteriesByRand();
	}

	@Override
	public int updateOpenIdById(String openId,int id) {
		return lotteriesDao.updateOpenIdById(openId,id);
	}

	@Override
	public Lotteries getLotteriesByOpenId(String openId) {
		return lotteriesDao.getLotteriesByOpenId(openId);
	}

	@Override
	public List<Lotteries> getLotteriesListByHasOpenId() {
		return lotteriesDao.getLotteriesListByHasOpenId();
	}
}