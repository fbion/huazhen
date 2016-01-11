package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzfh.service.employee.dao.TempRecruitDetailDao;
import com.hzfh.service.employee.mapper.TempRecruitDetailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("tempRecruitDetailDao")
public class TempRecruitDetailDaoImpl extends BaseDaoImpl<TempRecruitDetail, TempRecruitDetailCondition, TempRecruitDetailMapper> implements TempRecruitDetailDao {
@Autowired
private TempRecruitDetailMapper tempRecruitDetailMapper;
	@Override
	public TempRecruitDetail getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return tempRecruitDetailMapper.getInfoByNeedNo(id);
	}
	@Override
	public int updateByNeedNo(TempRecruitDetail tempRecruitDetail) {
		// TODO Auto-generated method stub
		return tempRecruitDetailMapper.updateByNeedNo(tempRecruitDetail);
	}
}