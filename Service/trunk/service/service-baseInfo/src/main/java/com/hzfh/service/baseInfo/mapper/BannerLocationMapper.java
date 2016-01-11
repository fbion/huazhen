package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("bannerLocationMapper")
public interface BannerLocationMapper extends BaseMapper<BannerLocation, BannerLocationCondition> {

	BannerLocation getInfoByCondition(BannerLocationCondition bannerLocationCondition);
}