package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeNeed1;
import com.hzfh.api.baseInfo.model.query.CodeNeed1Condition;
import com.hzfh.service.baseInfo.dao.CodeNeed1Dao;
import com.hzfh.service.baseInfo.mapper.CodeNeed1Mapper;
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


@Service("codeNeed1Dao")
public class CodeNeed1DaoImpl extends BaseDaoImpl<CodeNeed1, CodeNeed1Condition, CodeNeed1Mapper> implements CodeNeed1Dao {
}