package com.hzfh.service.sales.mapper;

import java.util.List;

import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.springframework.stereotype.Service;

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


@Service("applyEmployeeMapper")
public interface ApplyEmployeeMapper extends BaseMapper<ApplyEmployee, ApplyEmployeeCondition> {

	ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee);

	List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition);

	List<ApplyEmployee> getCustomerListForExcel(ApplyEmployeeCondition applyEmployeeCondition);
}