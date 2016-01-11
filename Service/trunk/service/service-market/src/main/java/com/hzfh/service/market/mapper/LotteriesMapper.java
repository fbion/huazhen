package com.hzfh.service.market.mapper;

import java.util.List;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.model.query.LotteriesCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("lotteriesMapper")
public interface LotteriesMapper extends BaseMapper<Lotteries, LotteriesCondition> {

	Lotteries getLotteriesByRand();

	int updateOpenIdById(@Param("openId")String openId, @Param("id")int id);

	Lotteries getLotteriesByOpenId(@Param("openId")String openId);

	List<Lotteries> getLotteriesListByHasOpenId();
}