package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.api.baseInfo.model.query.CodeAdviserCondition;
import com.hzfh.api.baseInfo.service.CodeAdviserService;
import com.hzfh.service.baseInfo.dao.CodeAdviserDao;
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


@Service("codeAdviserService")
public class CodeAdviserServiceImpl extends BaseServiceImpl<CodeAdviser, CodeAdviserCondition, CodeAdviserDao> implements CodeAdviserService {
}