package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeExpense;
import com.hzfh.api.baseInfo.model.query.CodeExpenseCondition;
import com.hzfh.service.baseInfo.dao.CodeExpenseDao;
import com.hzfh.service.baseInfo.mapper.CodeExpenseMapper;
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


@Service("codeExpenseDao")
public class CodeExpenseDaoImpl extends BaseDaoImpl<CodeExpense, CodeExpenseCondition, CodeExpenseMapper> implements CodeExpenseDao {
}