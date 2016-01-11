package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeCus2;
import com.hzfh.api.baseInfo.model.query.CodeCus2Condition;
import com.hzfh.service.baseInfo.dao.CodeCus2Dao;
import com.hzfh.service.baseInfo.mapper.CodeCus2Mapper;
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


@Service("codeCus2Dao")
public class CodeCus2DaoImpl extends BaseDaoImpl<CodeCus2, CodeCus2Condition, CodeCus2Mapper> implements CodeCus2Dao {
}