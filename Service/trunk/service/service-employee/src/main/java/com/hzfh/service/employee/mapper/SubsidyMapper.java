package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("subsidyMapper")
public interface SubsidyMapper extends BaseMapper<Subsidy, SubsidyCondition> {

	List<Subsidy> getListForExcel(SubsidyCondition subsidyCondition);

	List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition);

	List<Subsidy> getListByEmpNo(int empNo);
}