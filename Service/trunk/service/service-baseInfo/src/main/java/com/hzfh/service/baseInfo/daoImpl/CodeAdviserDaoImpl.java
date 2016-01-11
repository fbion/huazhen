package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.api.baseInfo.model.query.CodeAdviserCondition;
import com.hzfh.service.baseInfo.dao.CodeAdviserDao;
import com.hzfh.service.baseInfo.mapper.CodeAdviserMapper;
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


@Service("codeAdviserDao")
public class CodeAdviserDaoImpl extends BaseDaoImpl<CodeAdviser, CodeAdviserCondition, CodeAdviserMapper> implements CodeAdviserDao {
}