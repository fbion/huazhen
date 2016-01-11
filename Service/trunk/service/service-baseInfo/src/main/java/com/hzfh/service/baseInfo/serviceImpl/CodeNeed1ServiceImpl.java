package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeNeed1;
import com.hzfh.api.baseInfo.model.query.CodeNeed1Condition;
import com.hzfh.api.baseInfo.service.CodeNeed1Service;
import com.hzfh.service.baseInfo.dao.CodeNeed1Dao;
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


@Service("codeNeed1Service")
public class CodeNeed1ServiceImpl extends BaseServiceImpl<CodeNeed1, CodeNeed1Condition, CodeNeed1Dao> implements CodeNeed1Service {
}