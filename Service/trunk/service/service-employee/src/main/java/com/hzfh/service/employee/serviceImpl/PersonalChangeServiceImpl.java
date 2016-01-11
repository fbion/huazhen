package com.hzfh.service.employee.serviceImpl;

import java.util.List;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzfh.api.employee.service.PersonalChangeService;
import com.hzfh.service.employee.dao.InterviewEvaluationRecordDao;
import com.hzfh.service.employee.dao.PersonalChangeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("personalChangeService")
public class PersonalChangeServiceImpl extends BaseServiceImpl<PersonalChange, PersonalChangeCondition, PersonalChangeDao> implements PersonalChangeService {
	@Autowired
	    private PersonalChangeDao personalChangeDao;
	@Override
	public PersonalChange getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return personalChangeDao.getByActivitiNo(activitiNo);
	}
}