package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeCus1;
import com.hzfh.api.baseInfo.model.query.CodeCus1Condition;
import com.hzfh.service.baseInfo.dao.CodeCus1Dao;
import com.hzfh.service.baseInfo.mapper.CodeCus1Mapper;
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


@Service("codeCus1Dao")
public class CodeCus1DaoImpl extends BaseDaoImpl<CodeCus1, CodeCus1Condition, CodeCus1Mapper> implements CodeCus1Dao {
}