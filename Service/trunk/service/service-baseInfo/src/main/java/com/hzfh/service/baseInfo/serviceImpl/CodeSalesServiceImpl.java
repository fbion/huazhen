package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeSales;
import com.hzfh.api.baseInfo.model.query.CodeSalesCondition;
import com.hzfh.api.baseInfo.service.CodeSalesService;
import com.hzfh.service.baseInfo.dao.CodeSalesDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("codeSalesService")
public class CodeSalesServiceImpl extends BaseServiceImpl<CodeSales, CodeSalesCondition, CodeSalesDao> implements CodeSalesService {
}