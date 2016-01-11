package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface CityDao extends BaseDao<City, CityCondition> {

	List<City> getCityListByProvinceNo(int provinceNo);

	List<City> getCityListByProvinceNoAndEnabled(int provinceNo, byte enabled);
}