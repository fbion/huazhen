package com.hzfh.api.report.service;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzframework.data.service.BaseService;

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


public interface AddCustomerReportService extends BaseService<AddCustomerReport, AddCustomerReportCondition> {
    public List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition);
}