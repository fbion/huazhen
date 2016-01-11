package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
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


@Service("cityMapper")
public interface CityMapper extends BaseMapper<City, CityCondition> {

	List<City> getCityListByProvinceNo(int provinceNo);

	List<City> getCityListByProvinceNoAndEnabled(@Param("provinceNo")int provinceNo,@Param("enabled") byte enabled);
}