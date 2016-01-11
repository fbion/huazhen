package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
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


public interface ProvinceService extends BaseService<Province, ProvinceCondition> {
	public List<Province> getListByEnabled(byte enabled);
}