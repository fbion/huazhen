package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.service.report.dao.AddSalesReportDao;
import com.hzfh.service.report.mapper.AddSalesReportMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("addSalesReportDao")
public class AddSalesReportDaoImpl extends BaseDaoImpl<AddSalesReport, AddSalesReportCondition, AddSalesReportMapper> implements AddSalesReportDao {
    @Autowired
    private AddSalesReportMapper addSalesReportMapper;

    @Override
    public List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition) {
        return addSalesReportMapper.getListSerch(addSalesReportCondition);
    }
}