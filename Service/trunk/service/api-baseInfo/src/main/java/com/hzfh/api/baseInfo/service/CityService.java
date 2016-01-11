package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzframework.data.service.BaseService;

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


public interface CityService extends BaseService<City, CityCondition> {
	public List<City> getCityListByProvinceNo(int provinceNo);
	public List<City> getCityListByProvinceNoAndEnabled(int provinceNo,byte enabled);
	
}