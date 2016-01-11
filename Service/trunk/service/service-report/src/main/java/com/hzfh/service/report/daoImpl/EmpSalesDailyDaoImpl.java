package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.EmpSalesDaily;
import com.hzfh.api.report.model.query.EmpSalesDailyCondition;
import com.hzfh.service.report.dao.EmpSalesDailyDao;
import com.hzfh.service.report.mapper.EmpSalesDailyMapper;
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


@Service("empSalesDailyDao")
public class EmpSalesDailyDaoImpl extends BaseDaoImpl<EmpSalesDaily, EmpSalesDailyCondition, EmpSalesDailyMapper> implements EmpSalesDailyDao {
}