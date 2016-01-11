package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.api.report.service.AddCustomerReportService;
import com.hzfh.service.report.dao.AddCustomerReportDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("addCustomerReportService")
public class AddCustomerReportServiceImpl extends BaseServiceImpl<AddCustomerReport, AddCustomerReportCondition, AddCustomerReportDao> implements AddCustomerReportService {
    @Autowired
    private AddCustomerReportDao addCustomerReportDao;
    @Override
    public List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition){
        return addCustomerReportDao.getListSerch(addCustomerReportCondition);
    }
}