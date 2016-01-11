package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.DeptSalesDaily;
import com.hzfh.api.report.model.query.DeptSalesDailyCondition;
import com.hzfh.api.report.service.DeptSalesDailyService;
import com.hzfh.service.report.dao.DeptSalesDailyDao;
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


@Service("deptSalesDailyService")
public class DeptSalesDailyServiceImpl extends BaseServiceImpl<DeptSalesDaily, DeptSalesDailyCondition, DeptSalesDailyDao> implements DeptSalesDailyService {
}