package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.service.employee.dao.CompanyDao;
import com.hzfh.service.employee.mapper.CompanyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<Company, CompanyCondition, CompanyMapper> implements CompanyDao {
	@Autowired
	private CompanyMapper companyMapper;
	@Override
	public List<Company> getCompanylist() {
		return companyMapper.getCompanylist();
	}
	@Override
	public Company getCompanyByCompanyId(int companyId) {
		return companyMapper.getCompanyByCompanyId(companyId);
	}

}