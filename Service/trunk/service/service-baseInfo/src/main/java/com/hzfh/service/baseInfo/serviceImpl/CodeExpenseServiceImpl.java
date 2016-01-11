package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeExpense;
import com.hzfh.api.baseInfo.model.query.CodeExpenseCondition;
import com.hzfh.api.baseInfo.service.CodeExpenseService;
import com.hzfh.service.baseInfo.dao.CodeExpenseDao;
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


@Service("codeExpenseService")
public class CodeExpenseServiceImpl extends BaseServiceImpl<CodeExpense, CodeExpenseCondition, CodeExpenseDao> implements CodeExpenseService {
}