package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeProduct4;
import com.hzfh.api.baseInfo.model.query.CodeProduct4Condition;
import com.hzfh.service.baseInfo.dao.CodeProduct4Dao;
import com.hzfh.service.baseInfo.mapper.CodeProduct4Mapper;
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


@Service("codeProduct4Dao")
public class CodeProduct4DaoImpl extends BaseDaoImpl<CodeProduct4, CodeProduct4Condition, CodeProduct4Mapper> implements CodeProduct4Dao {
}