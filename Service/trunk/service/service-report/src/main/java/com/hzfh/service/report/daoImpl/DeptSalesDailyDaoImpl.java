package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.DeptSalesDaily;
import com.hzfh.api.report.model.query.DeptSalesDailyCondition;
import com.hzfh.service.report.dao.DeptSalesDailyDao;
import com.hzfh.service.report.mapper.DeptSalesDailyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("deptSalesDailyDao")
public class DeptSalesDailyDaoImpl extends BaseDaoImpl<DeptSalesDaily, DeptSalesDailyCondition, DeptSalesDailyMapper> implements DeptSalesDailyDao {
}