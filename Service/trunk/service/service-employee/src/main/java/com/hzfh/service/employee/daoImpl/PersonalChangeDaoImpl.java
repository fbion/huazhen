package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzfh.service.employee.dao.PersonalChangeDao;
import com.hzfh.service.employee.mapper.KnowledgeAttachmentMapper;
import com.hzfh.service.employee.mapper.PersonalChangeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("personalChangeDao")
public class PersonalChangeDaoImpl extends BaseDaoImpl<PersonalChange, PersonalChangeCondition, PersonalChangeMapper> implements PersonalChangeDao {
	@Autowired 
	private PersonalChangeMapper personalChangeMapper;
	
	@Override
	public PersonalChange getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return personalChangeMapper.getByActivitiNo(activitiNo);
	}
}