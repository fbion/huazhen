package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface DeptYearNeedDetailService extends BaseService<DeptYearNeedDetail, DeptYearNeedDetailCondition> {

	List<DeptYearNeedDetail> getInfoByNeedNo(int id);
}