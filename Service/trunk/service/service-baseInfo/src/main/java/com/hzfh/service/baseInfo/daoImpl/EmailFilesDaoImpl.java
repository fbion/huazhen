package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.baseInfo.model.query.EmailFilesCondition;
import com.hzfh.service.baseInfo.dao.EmailFilesDao;
import com.hzfh.service.baseInfo.mapper.EmailFilesMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("emailFilesDao")
public class EmailFilesDaoImpl extends BaseDaoImpl<EmailFiles, EmailFilesCondition, EmailFilesMapper> implements EmailFilesDao {
}