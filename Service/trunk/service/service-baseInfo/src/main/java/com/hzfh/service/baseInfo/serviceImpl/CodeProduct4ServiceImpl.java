package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeProduct4;
import com.hzfh.api.baseInfo.model.query.CodeProduct4Condition;
import com.hzfh.api.baseInfo.service.CodeProduct4Service;
import com.hzfh.service.baseInfo.dao.CodeProduct4Dao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("codeProduct4Service")
public class CodeProduct4ServiceImpl extends BaseServiceImpl<CodeProduct4, CodeProduct4Condition, CodeProduct4Dao> implements CodeProduct4Service {
}