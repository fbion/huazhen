package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.service.customer.dao.EmailChangeDao;
import com.hzfh.service.customer.mapper.EmailChangeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("emailChangeDao")
public class EmailChangeDaoImpl extends BaseDaoImpl<EmailChange, EmailChangeCondition, EmailChangeMapper> implements EmailChangeDao {
	@Autowired
	private EmailChangeMapper mailChangeMapper;
	@Override
	public List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition) {
		return mailChangeMapper.getListByCondition(emailChangeCondition);
	}
}