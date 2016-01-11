package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.api.customer.service.EmailChangeService;
import com.hzfh.service.customer.dao.EmailChangeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("emailChangeService")
public class EmailChangeServiceImpl extends BaseServiceImpl<EmailChange, EmailChangeCondition, EmailChangeDao> implements EmailChangeService {
	@Autowired
	private EmailChangeDao emailChangeDao;
	@Override
	public List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition) {
		return emailChangeDao.getListByCondition(emailChangeCondition);
	}
}