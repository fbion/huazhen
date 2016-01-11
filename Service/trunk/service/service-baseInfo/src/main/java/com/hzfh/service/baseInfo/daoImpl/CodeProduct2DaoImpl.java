package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeProduct2;
import com.hzfh.api.baseInfo.model.query.CodeProduct2Condition;
import com.hzfh.service.baseInfo.dao.CodeProduct2Dao;
import com.hzfh.service.baseInfo.mapper.CodeProduct2Mapper;
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


@Service("codeProduct2Dao")
public class CodeProduct2DaoImpl extends BaseDaoImpl<CodeProduct2, CodeProduct2Condition, CodeProduct2Mapper> implements CodeProduct2Dao {
}