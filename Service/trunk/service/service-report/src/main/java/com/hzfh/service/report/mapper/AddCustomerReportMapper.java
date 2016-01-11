package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/15 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("addCustomerReportMapper")
public interface AddCustomerReportMapper extends BaseMapper<AddCustomerReport, AddCustomerReportCondition> {
    public List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition);

}