package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeIssue;
import com.hzfh.api.baseInfo.model.query.CodeIssueCondition;
import com.hzfh.api.baseInfo.service.CodeIssueService;
import com.hzfh.service.baseInfo.dao.CodeIssueDao;
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


@Service("codeIssueService")
public class CodeIssueServiceImpl extends BaseServiceImpl<CodeIssue, CodeIssueCondition, CodeIssueDao> implements CodeIssueService {
}