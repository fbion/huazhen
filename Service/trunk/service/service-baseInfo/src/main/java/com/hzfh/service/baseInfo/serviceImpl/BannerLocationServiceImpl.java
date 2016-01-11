package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzfh.api.baseInfo.service.BannerLocationService;
import com.hzfh.service.baseInfo.dao.BannerLocationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("bannerLocationService")
public class BannerLocationServiceImpl extends BaseServiceImpl<BannerLocation, BannerLocationCondition, BannerLocationDao> implements BannerLocationService {

	@Autowired
	private BannerLocationDao bannerLocationDao;
	@Override
	public BannerLocation getInfoByCondition(
			BannerLocationCondition bannerLocationCondition) {
		return bannerLocationDao.getInfoByCondition(bannerLocationCondition);
	}
}