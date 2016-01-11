package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface SnDao extends BaseDao<Sn, SnCondition> {

	void truncateSn();
}