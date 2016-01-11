package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeProduct1;
import com.hzfh.api.baseInfo.model.query.CodeProduct1Condition;
import com.hzfh.service.baseInfo.dao.CodeProduct1Dao;
import com.hzfh.service.baseInfo.mapper.CodeProduct1Mapper;
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


@Service("codeProduct1Dao")
public class CodeProduct1DaoImpl extends BaseDaoImpl<CodeProduct1, CodeProduct1Condition, CodeProduct1Mapper> implements CodeProduct1Dao {
}