package com.hzfh.api.report.service;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzframework.data.service.BaseService;

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


public interface AddSalesReportService extends BaseService<AddSalesReport, AddSalesReportCondition> {
    List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition);
}