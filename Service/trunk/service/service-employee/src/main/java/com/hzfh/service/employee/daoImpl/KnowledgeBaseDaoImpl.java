package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.service.employee.dao.KnowledgeBaseDao;
import com.hzfh.service.employee.mapper.KnowledgeBaseMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("knowledgeBaseDao")
public class KnowledgeBaseDaoImpl extends BaseDaoImpl<KnowledgeBase, KnowledgeBaseCondition, KnowledgeBaseMapper> implements KnowledgeBaseDao {
}