package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
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


public interface ProvinceDao extends BaseDao<Province, ProvinceCondition> {

	List<Province> getListByEnabled(byte enabled);
}