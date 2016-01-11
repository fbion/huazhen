package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzfh.api.employee.service.YearNeedTotalService;
import com.hzfh.service.employee.dao.YearNeedTotalDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("yearNeedTotalService")
public class YearNeedTotalServiceImpl extends BaseServiceImpl<YearNeedTotal, YearNeedTotalCondition, YearNeedTotalDao> implements YearNeedTotalService {
@Autowired
private YearNeedTotalDao yearNeedTotalDao;
	@Override
	public YearNeedTotal getInfoByYear(int financialYear) {
		// TODO Auto-generated method stub
		return yearNeedTotalDao.getInfoByYear(financialYear);
	}
}