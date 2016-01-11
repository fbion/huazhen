package com.hzfh.api.baseInfo.service;

import java.util.List;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzframework.data.service.BaseService;

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


public interface BannerInfoService extends BaseService<BannerInfo, BannerInfoCondition> {

	List<BannerInfo> getInfoListByCondition(BannerInfoCondition bannerInfoCondition);
}