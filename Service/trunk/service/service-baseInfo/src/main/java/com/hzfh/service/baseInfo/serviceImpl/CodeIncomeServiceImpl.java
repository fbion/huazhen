package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeIncome;
import com.hzfh.api.baseInfo.model.query.CodeIncomeCondition;
import com.hzfh.api.baseInfo.service.CodeIncomeService;
import com.hzfh.service.baseInfo.dao.CodeIncomeDao;
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


@Service("codeIncomeService")
public class CodeIncomeServiceImpl extends BaseServiceImpl<CodeIncome, CodeIncomeCondition, CodeIncomeDao> implements CodeIncomeService {
}