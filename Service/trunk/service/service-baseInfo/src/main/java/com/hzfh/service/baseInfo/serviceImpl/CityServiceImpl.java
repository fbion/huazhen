package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzfh.api.baseInfo.service.CityService;
import com.hzfh.service.baseInfo.dao.CityDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, CityCondition, CityDao> implements CityService {

	@Autowired
    private CityDao cityDao;
	@Override
	public List<City> getCityListByProvinceNo(int provinceNo) {
		return cityDao.getCityListByProvinceNo(provinceNo);
	}
	@Override
	public List<City> getCityListByProvinceNoAndEnabled(int provinceNo, byte enabled) {
	
		return cityDao.getCityListByProvinceNoAndEnabled(provinceNo,enabled);
	}
}