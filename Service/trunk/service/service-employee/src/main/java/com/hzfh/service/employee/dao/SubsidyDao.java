package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface SubsidyDao extends BaseDao<Subsidy, SubsidyCondition> {

	List<Subsidy> getListForExcel(SubsidyCondition subsidyCondition);

	List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition);

	List<Subsidy> getListByEmpNo(int empNo);
}