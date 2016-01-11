package com.hzfh.service.baseInfo.mapper;

import java.util.List;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzframework.data.mapper.BaseMapper;

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


@Service("bannerInfoMapper")
public interface BannerInfoMapper extends BaseMapper<BannerInfo, BannerInfoCondition> {

	List<BannerInfo> getInfoListByCondition(
			BannerInfoCondition bannerInfoCondition);
}