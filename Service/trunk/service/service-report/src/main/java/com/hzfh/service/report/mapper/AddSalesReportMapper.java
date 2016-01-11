package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/11/6 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("addSalesReportMapper")
public interface AddSalesReportMapper extends BaseMapper<AddSalesReport, AddSalesReportCondition> {
    public List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition);
}