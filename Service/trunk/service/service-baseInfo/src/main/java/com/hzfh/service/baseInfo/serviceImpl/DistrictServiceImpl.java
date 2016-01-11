package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
import com.hzfh.api.baseInfo.service.DistrictService;
import com.hzfh.service.baseInfo.dao.DistrictDao;
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


@Service("districtService")
public class DistrictServiceImpl extends BaseServiceImpl<District, DistrictCondition, DistrictDao> implements DistrictService {

	@Autowired
    private DistrictDao districtDao;
	@Override
	public List<District> getDistrictListByCityNo(int cityNo) {
		return districtDao.getDistrictListByCityNo(cityNo);
	}
	@Override
	public List<District> getDistrictListByCityNoAndEnabled(int cityNo, byte enabled) {
		return districtDao.getDistrictListByCityNoAndEnabled(cityNo,enabled);
	}
}