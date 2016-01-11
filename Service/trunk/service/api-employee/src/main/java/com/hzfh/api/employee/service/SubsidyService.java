package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface SubsidyService extends BaseService<Subsidy, SubsidyCondition> {

	List<Subsidy> getListForExcel(SubsidyCondition subsidyCondition);

	List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition);

	List<Subsidy> getListByEmpNo(int empNo);
}