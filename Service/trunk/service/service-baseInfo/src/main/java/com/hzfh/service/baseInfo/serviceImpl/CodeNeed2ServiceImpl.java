package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeNeed2;
import com.hzfh.api.baseInfo.model.query.CodeNeed2Condition;
import com.hzfh.api.baseInfo.service.CodeNeed2Service;
import com.hzfh.service.baseInfo.dao.CodeNeed2Dao;
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


@Service("codeNeed2Service")
public class CodeNeed2ServiceImpl extends BaseServiceImpl<CodeNeed2, CodeNeed2Condition, CodeNeed2Dao> implements CodeNeed2Service {
}