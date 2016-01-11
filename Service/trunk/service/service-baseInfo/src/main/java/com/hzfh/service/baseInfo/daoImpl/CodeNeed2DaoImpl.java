package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeNeed2;
import com.hzfh.api.baseInfo.model.query.CodeNeed2Condition;
import com.hzfh.service.baseInfo.dao.CodeNeed2Dao;
import com.hzfh.service.baseInfo.mapper.CodeNeed2Mapper;
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


@Service("codeNeed2Dao")
public class CodeNeed2DaoImpl extends BaseDaoImpl<CodeNeed2, CodeNeed2Condition, CodeNeed2Mapper> implements CodeNeed2Dao {
}