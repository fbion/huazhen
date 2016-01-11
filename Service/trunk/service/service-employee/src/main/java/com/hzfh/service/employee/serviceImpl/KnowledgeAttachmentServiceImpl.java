package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzfh.api.employee.service.KnowledgeAttachmentService;
import com.hzfh.service.employee.dao.KnowledgeAttachmentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("knowledgeAttachmentService")
public class KnowledgeAttachmentServiceImpl extends BaseServiceImpl<KnowledgeAttachment, KnowledgeAttachmentCondition, KnowledgeAttachmentDao> implements KnowledgeAttachmentService {
	@Autowired
	private KnowledgeAttachmentDao knowledgeAttachmentDao;
	@Override
	public int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		return knowledgeAttachmentDao.updateStatus(id,status);
	}

	@Override
	public List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo) {
		// TODO Auto-generated method stub
		return knowledgeAttachmentDao.getListByKnowledgeNo(knowledgeNo);
	}
}