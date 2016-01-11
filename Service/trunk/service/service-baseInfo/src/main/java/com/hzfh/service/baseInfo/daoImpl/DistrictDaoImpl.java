package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
import com.hzfh.service.baseInfo.dao.DistrictDao;
import com.hzfh.service.baseInfo.mapper.DistrictMapper;
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


@Service("districtDao")
public class DistrictDaoImpl extends BaseDaoImpl<District, DistrictCondition, DistrictMapper> implements DistrictDao {

	@Autowired
    private DistrictMapper districtMapper;
	@Override
	public List<District> getDistrictListByCityNo(int cityNo) {
		return districtMapper.getDistrictListByCityNo(cityNo) ;
	}
	@Override
	public List<District> getDistrictListByCityNoAndEnabled(int cityNo, byte enabled) {
		return districtMapper.getDistrictListByCityNoAndEnabled(cityNo,enabled);
	}
}