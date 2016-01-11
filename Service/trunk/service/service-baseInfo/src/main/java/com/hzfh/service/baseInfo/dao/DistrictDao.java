package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
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


public interface DistrictDao extends BaseDao<District, DistrictCondition> {

	List<District> getDistrictListByCityNo(int cityNo);

	List<District> getDistrictListByCityNoAndEnabled(int cityNo, byte enabled);
}