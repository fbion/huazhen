package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("districtMapper")
public interface DistrictMapper extends BaseMapper<District, DistrictCondition> {

	List<District> getDistrictListByCityNo(int cityNo);

	List<District> getDistrictListByCityNoAndEnabled(@Param("cityNo")int cityNo, @Param("enabled")byte enabled);
}