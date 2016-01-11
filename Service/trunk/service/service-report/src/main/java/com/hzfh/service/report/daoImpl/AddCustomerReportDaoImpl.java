package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.service.report.dao.AddCustomerReportDao;
import com.hzfh.service.report.mapper.AddCustomerReportMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("addCustomerReportDao")
public class AddCustomerReportDaoImpl extends BaseDaoImpl<AddCustomerReport, AddCustomerReportCondition, AddCustomerReportMapper> implements AddCustomerReportDao {
    @Autowired
    private AddCustomerReportMapper addCustomerReportMapper;
    @Override
    public List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition){
        return addCustomerReportMapper.getListSerch(addCustomerReportCondition);
    }

}