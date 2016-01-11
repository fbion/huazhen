package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.api.employee.service.KnowledgeBaseService;
import com.hzfh.service.employee.dao.KnowledgeBaseDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("knowledgeBaseService")
public class KnowledgeBaseServiceImpl extends BaseServiceImpl<KnowledgeBase, KnowledgeBaseCondition, KnowledgeBaseDao> implements KnowledgeBaseService {
}