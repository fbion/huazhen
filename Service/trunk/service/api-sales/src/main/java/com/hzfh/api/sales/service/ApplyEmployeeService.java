package com.hzfh.api.sales.service;

import java.util.List;

import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface ApplyEmployeeService extends BaseService<ApplyEmployee, ApplyEmployeeCondition> {

	ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee);

	List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition);

	List<ApplyEmployee> getCustomerListForExcel(ApplyEmployeeCondition applyEmployeeCondition);
}