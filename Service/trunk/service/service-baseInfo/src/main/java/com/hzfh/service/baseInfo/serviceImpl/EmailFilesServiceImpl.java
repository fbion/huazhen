package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.baseInfo.model.query.EmailFilesCondition;
import com.hzfh.api.baseInfo.service.EmailFilesService;
import com.hzfh.service.baseInfo.dao.EmailFilesDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("emailFilesService")
public class EmailFilesServiceImpl extends BaseServiceImpl<EmailFiles, EmailFilesCondition, EmailFilesDao> implements EmailFilesService {
}