package com.hzfh.api.market.service;

import java.util.List;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.api.market.model.query.LotteriesCondition;
import com.hzframework.data.service.BaseService;

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


public interface LotteriesService extends BaseService<Lotteries, LotteriesCondition> {
	/**
	 * 自动获取一个随机记录
	 * @return 随机 Lotteries
	 */
	public Lotteries getLotteriesByRand();
	/**
	 * 根据id更新open_id
	 * @param id
	 * @return n 修改行数
	 */
	public int updateOpenIdById(String openId,int id);
	/**
	 * 通过open_id获取info
	 * @param openId
	 * @return Lotteries
	 */
	public Lotteries  getLotteriesByOpenId(String openId);
	/**
	 * 获取所有含有open_id的数据
	 * @return List<Lotteries>
	 */
	public List<Lotteries> getLotteriesListByHasOpenId();
}