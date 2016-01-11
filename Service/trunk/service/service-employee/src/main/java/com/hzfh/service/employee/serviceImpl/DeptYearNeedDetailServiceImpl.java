package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzfh.api.employee.service.DeptYearNeedDetailService;
import com.hzfh.service.employee.dao.DeptYearNeedDetailDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("deptYearNeedDetailService")
public class DeptYearNeedDetailServiceImpl extends BaseServiceImpl<DeptYearNeedDetail, DeptYearNeedDetailCondition, DeptYearNeedDetailDao> implements DeptYearNeedDetailService {
	@Autowired
	private DeptYearNeedDetailDao deptYearNeedDetailDao;
	@Override
	public List<DeptYearNeedDetail> getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return deptYearNeedDetailDao.getInfoByNeedNo(id);
	}
}