package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzfh.service.employee.dao.KnowledgeAttachmentDao;
import com.hzfh.service.employee.mapper.KnowledgeAttachmentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("knowledgeAttachmentDao")
public class KnowledgeAttachmentDaoImpl extends BaseDaoImpl<KnowledgeAttachment, KnowledgeAttachmentCondition, KnowledgeAttachmentMapper> implements KnowledgeAttachmentDao {
	@Autowired 
	private KnowledgeAttachmentMapper knowledgeAttachmentMapper;
	
	@Override
	public int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		return knowledgeAttachmentMapper.updateStatus(id,status);
	}

	@Override
	public List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo) {
		// TODO Auto-generated method stub
		return knowledgeAttachmentMapper.getListByKnowledgeNo(knowledgeNo);
	}
}