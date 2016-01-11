package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzfh.api.employee.service.YearNeedDetailService;
import com.hzfh.service.employee.dao.YearNeedDetailDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedDetailService")
public class YearNeedDetailServiceImpl extends BaseServiceImpl<YearNeedDetail, YearNeedDetailCondition, YearNeedDetailDao> implements YearNeedDetailService {
@Autowired
private YearNeedDetailDao yearNeedDetailDao;
	@Override
	public List<YearNeedDetail> getListByNeedNo(int id) {
		// TODO Auto-generated method stub
		return yearNeedDetailDao.getListByNeedNo(id);
	}
}