package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface YearNeedDetailService extends BaseService<YearNeedDetail, YearNeedDetailCondition> {

	List<YearNeedDetail> getListByNeedNo(int id);
}