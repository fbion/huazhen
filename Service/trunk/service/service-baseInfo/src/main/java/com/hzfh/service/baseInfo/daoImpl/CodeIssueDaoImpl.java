package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeIssue;
import com.hzfh.api.baseInfo.model.query.CodeIssueCondition;
import com.hzfh.service.baseInfo.dao.CodeIssueDao;
import com.hzfh.service.baseInfo.mapper.CodeIssueMapper;
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


@Service("codeIssueDao")
public class CodeIssueDaoImpl extends BaseDaoImpl<CodeIssue, CodeIssueCondition, CodeIssueMapper> implements CodeIssueDao {
}