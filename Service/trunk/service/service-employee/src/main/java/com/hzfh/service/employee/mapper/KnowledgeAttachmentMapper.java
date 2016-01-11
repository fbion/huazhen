package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("knowledgeAttachmentMapper")
public interface KnowledgeAttachmentMapper extends BaseMapper<KnowledgeAttachment, KnowledgeAttachmentCondition> {

	int updateStatus(int id, byte status);

	List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo);
}