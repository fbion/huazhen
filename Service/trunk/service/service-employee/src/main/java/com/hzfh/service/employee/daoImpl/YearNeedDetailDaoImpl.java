package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzfh.service.employee.dao.YearNeedDetailDao;
import com.hzfh.service.employee.mapper.YearNeedDetailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("yearNeedDetailDao")
public class YearNeedDetailDaoImpl extends BaseDaoImpl<YearNeedDetail, YearNeedDetailCondition, YearNeedDetailMapper> implements YearNeedDetailDao {
@Autowired
private YearNeedDetailMapper yearNeedDetailMapper;
	@Override
	public List<YearNeedDetail> getListByNeedNo(int id) {
		// TODO Auto-generated method stub
		return yearNeedDetailMapper.getListByNeedNo(id);
	}
}