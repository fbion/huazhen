package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
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


public interface DistrictService extends BaseService<District, DistrictCondition> {
	public List<District> getDistrictListByCityNo(int cityNo);
	public List<District> getDistrictListByCityNoAndEnabled(int cityNo,byte enabled);
	
}