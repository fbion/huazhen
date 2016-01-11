package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface BannerLocationDao extends BaseDao<BannerLocation, BannerLocationCondition> {

	BannerLocation getInfoByCondition(
			BannerLocationCondition bannerLocationCondition);
}