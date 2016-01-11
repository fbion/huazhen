package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/1 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface KnowledgeAttachmentService extends BaseService<KnowledgeAttachment, KnowledgeAttachmentCondition> {

	int updateStatus(int id, byte status);

	List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo);
}