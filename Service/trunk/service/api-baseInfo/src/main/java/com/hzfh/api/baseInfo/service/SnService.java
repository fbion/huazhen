package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzframework.data.service.BaseService;

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


public interface SnService extends BaseService<Sn, SnCondition> {

	public void truncateSn();
	public String getSn(SnEnum snEnum);
//	public String getSnHelper(SnEnum snEnum);


}