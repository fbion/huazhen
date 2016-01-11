package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface TempRecruitDetailService extends BaseService<TempRecruitDetail, TempRecruitDetailCondition> {

	TempRecruitDetail getInfoByNeedNo(int id);
	int updateByNeedNo(TempRecruitDetail tempRecruitDetail);
}