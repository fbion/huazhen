package com.hzfh.service.baseInfo.daoImpl;

import java.util.List;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.service.baseInfo.dao.BannerInfoDao;
import com.hzfh.service.baseInfo.mapper.BannerInfoMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("bannerInfoDao")
public class BannerInfoDaoImpl extends BaseDaoImpl<BannerInfo, BannerInfoCondition, BannerInfoMapper> implements BannerInfoDao {
	@Autowired
	private BannerInfoMapper bannerInfoMapper;
	@Override
	public List<BannerInfo> getInfoListByCondition(
			BannerInfoCondition bannerInfoCondition) {
		return bannerInfoMapper.getInfoListByCondition(bannerInfoCondition);
	}
}