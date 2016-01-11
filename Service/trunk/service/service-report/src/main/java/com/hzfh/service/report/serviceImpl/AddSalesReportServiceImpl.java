package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.api.report.service.AddSalesReportService;
import com.hzfh.service.report.dao.AddSalesReportDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("addSalesReportService")
public class AddSalesReportServiceImpl extends BaseServiceImpl<AddSalesReport, AddSalesReportCondition, AddSalesReportDao> implements AddSalesReportService {
    @Autowired
    private AddSalesReportDao addSalesReportDao;
    @Override
    public List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition) {
        return addSalesReportDao.getListSerch(addSalesReportCondition);
    }
}