package com.hzfh.service.baseInfo.serviceImpl;

import java.util.List;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.api.baseInfo.service.BannerInfoService;
import com.hzfh.service.baseInfo.dao.BannerInfoDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/15 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("bannerInfoService")
public class BannerInfoServiceImpl extends BaseServiceImpl<BannerInfo, BannerInfoCondition, BannerInfoDao> implements BannerInfoService {
	@Autowired
	private BannerInfoDao bannerInfoDao;
	@Override
	public List<BannerInfo> getInfoListByCondition(
			BannerInfoCondition bannerInfoCondition) {
		return bannerInfoDao.getInfoListByCondition(bannerInfoCondition);
	}
}