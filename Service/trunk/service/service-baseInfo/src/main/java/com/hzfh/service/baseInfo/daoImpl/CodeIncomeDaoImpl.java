package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeIncome;
import com.hzfh.api.baseInfo.model.query.CodeIncomeCondition;
import com.hzfh.service.baseInfo.dao.CodeIncomeDao;
import com.hzfh.service.baseInfo.mapper.CodeIncomeMapper;
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


@Service("codeIncomeDao")
public class CodeIncomeDaoImpl extends BaseDaoImpl<CodeIncome, CodeIncomeCondition, CodeIncomeMapper> implements CodeIncomeDao {
}