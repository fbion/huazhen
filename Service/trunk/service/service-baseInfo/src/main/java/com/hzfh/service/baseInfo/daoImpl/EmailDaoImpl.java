package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.query.EmailCondition;
import com.hzfh.service.baseInfo.dao.EmailDao;
import com.hzfh.service.baseInfo.mapper.EmailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("emailDao")
public class EmailDaoImpl extends BaseDaoImpl<Email, EmailCondition, EmailMapper> implements EmailDao {
}