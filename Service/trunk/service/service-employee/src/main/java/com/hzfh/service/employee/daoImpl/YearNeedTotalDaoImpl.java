package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzfh.service.employee.dao.YearNeedTotalDao;
import com.hzfh.service.employee.mapper.YearNeedTotalMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedTotalDao")
public class YearNeedTotalDaoImpl extends BaseDaoImpl<YearNeedTotal, YearNeedTotalCondition, YearNeedTotalMapper> implements YearNeedTotalDao {
	@Autowired 
	private YearNeedTotalMapper yearNeedTotalMapper;
	@Override
	public YearNeedTotal getInfoByYear(int financialYear) {
		// TODO Auto-generated method stub
		return yearNeedTotalMapper.getInfoByYear(financialYear);
	}
}