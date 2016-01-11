package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzfh.service.baseInfo.dao.CityDao;
import com.hzfh.service.baseInfo.mapper.CityMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City, CityCondition, CityMapper> implements CityDao {

	@Autowired
    private CityMapper cityMapper;
	@Override
	public List<City> getCityListByProvinceNo(int provinceNo) {
		return cityMapper.getCityListByProvinceNo(provinceNo);
	}
	@Override
	public List<City> getCityListByProvinceNoAndEnabled(int provinceNo, byte enabled) {
		return cityMapper.getCityListByProvinceNoAndEnabled(provinceNo,enabled);
	}
}