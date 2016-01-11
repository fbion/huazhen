package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeProduct3;
import com.hzfh.api.baseInfo.model.query.CodeProduct3Condition;
import com.hzfh.service.baseInfo.dao.CodeProduct3Dao;
import com.hzfh.service.baseInfo.mapper.CodeProduct3Mapper;
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


@Service("codeProduct3Dao")
public class CodeProduct3DaoImpl extends BaseDaoImpl<CodeProduct3, CodeProduct3Condition, CodeProduct3Mapper> implements CodeProduct3Dao {
}