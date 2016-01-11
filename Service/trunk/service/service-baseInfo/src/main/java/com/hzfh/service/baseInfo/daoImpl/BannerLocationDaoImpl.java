package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzfh.service.baseInfo.dao.BannerLocationDao;
import com.hzfh.service.baseInfo.mapper.BannerLocationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/16 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("bannerLocationDao")
public class BannerLocationDaoImpl extends BaseDaoImpl<BannerLocation, BannerLocationCondition, BannerLocationMapper> implements BannerLocationDao {
	@Autowired
	private BannerLocationMapper bannerLocationMapper;
	@Override
	public BannerLocation getInfoByCondition(BannerLocationCondition bannerLocationCondition) {
		return bannerLocationMapper.getInfoByCondition(bannerLocationCondition);
	}
}