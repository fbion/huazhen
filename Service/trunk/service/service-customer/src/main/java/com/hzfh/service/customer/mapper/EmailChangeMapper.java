package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzframework.data.mapper.BaseMapper;

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


@Service("emailChangeMapper")
public interface EmailChangeMapper extends BaseMapper<EmailChange, EmailChangeCondition> {

	List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition);
}