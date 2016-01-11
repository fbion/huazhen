package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.baseInfo.model.query.EmailFilesCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("emailFilesMapper")
public interface EmailFilesMapper extends BaseMapper<EmailFiles, EmailFilesCondition> {
}