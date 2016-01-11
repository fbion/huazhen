package com.hzfh.service.report.dao;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface AddSalesReportDao extends BaseDao<AddSalesReport, AddSalesReportCondition> {
    List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition);
}