package com.hzfh.service.market.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.model.query.LotteriesCondition;
import com.hzfh.service.market.dao.LotteriesDao;
import com.hzfh.service.market.mapper.LotteriesMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("lotteriesDao")
public class LotteriesDaoImpl extends BaseDaoImpl<Lotteries, LotteriesCondition, LotteriesMapper> implements LotteriesDao {
	@Autowired
	private LotteriesMapper lotteriesMapper;
	@Override
	public Lotteries getLotteriesByRand() {
		return lotteriesMapper.getLotteriesByRand();
	}

	@Override
	public int updateOpenIdById(String openId,int id) {
		return lotteriesMapper.updateOpenIdById(openId,id);
	}

	@Override
	public Lotteries getLotteriesByOpenId(String openId) {
		return lotteriesMapper.getLotteriesByOpenId(openId);
	}

	@Override
	public List<Lotteries> getLotteriesListByHasOpenId() {
		return lotteriesMapper.getLotteriesListByHasOpenId();
	}
}