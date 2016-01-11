package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.EmpSalesTotal;
import com.hzfh.api.report.model.query.EmpSalesTotalCondition;
import com.hzfh.service.report.dao.EmpSalesTotalDao;
import com.hzfh.service.report.mapper.EmpSalesTotalMapper;
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


@Service("empSalesTotalDao")
public class EmpSalesTotalDaoImpl extends BaseDaoImpl<EmpSalesTotal, EmpSalesTotalCondition, EmpSalesTotalMapper> implements EmpSalesTotalDao {
}