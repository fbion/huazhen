package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.EmpSalesTotal;
import com.hzfh.api.report.model.query.EmpSalesTotalCondition;
import com.hzfh.api.report.service.EmpSalesTotalService;
import com.hzfh.service.report.dao.EmpSalesTotalDao;
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


@Service("empSalesTotalService")
public class EmpSalesTotalServiceImpl extends BaseServiceImpl<EmpSalesTotal, EmpSalesTotalCondition, EmpSalesTotalDao> implements EmpSalesTotalService {
}