package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeSales;
import com.hzfh.api.baseInfo.model.query.CodeSalesCondition;
import com.hzfh.service.baseInfo.dao.CodeSalesDao;
import com.hzfh.service.baseInfo.mapper.CodeSalesMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/9 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("codeSalesDao")
public class CodeSalesDaoImpl extends BaseDaoImpl<CodeSales, CodeSalesCondition, CodeSalesMapper> implements CodeSalesDao {
}