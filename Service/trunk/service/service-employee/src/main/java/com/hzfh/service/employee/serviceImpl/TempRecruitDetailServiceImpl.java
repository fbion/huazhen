package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzfh.api.employee.service.TempRecruitDetailService;
import com.hzfh.service.employee.dao.TempRecruitDetailDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("tempRecruitDetailService")
public class TempRecruitDetailServiceImpl extends BaseServiceImpl<TempRecruitDetail, TempRecruitDetailCondition, TempRecruitDetailDao> implements TempRecruitDetailService {
@Autowired
private TempRecruitDetailDao tempRecruitDetailDao;
	@Override
	public TempRecruitDetail getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return tempRecruitDetailDao.getInfoByNeedNo(id);
	}
	@Override
	public int updateByNeedNo(TempRecruitDetail tempRecruitDetail) {
		// TODO Auto-generated method stub
		return tempRecruitDetailDao.updateByNeedNo(tempRecruitDetail);
	}
}