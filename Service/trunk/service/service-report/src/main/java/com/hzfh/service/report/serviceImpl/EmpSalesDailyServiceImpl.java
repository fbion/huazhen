package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.EmpSalesDaily;
import com.hzfh.api.report.model.query.EmpSalesDailyCondition;
import com.hzfh.api.report.service.EmpSalesDailyService;
import com.hzfh.service.report.dao.EmpSalesDailyDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("empSalesDailyService")
public class EmpSalesDailyServiceImpl extends BaseServiceImpl<EmpSalesDaily, EmpSalesDailyCondition, EmpSalesDailyDao> implements EmpSalesDailyService {
}