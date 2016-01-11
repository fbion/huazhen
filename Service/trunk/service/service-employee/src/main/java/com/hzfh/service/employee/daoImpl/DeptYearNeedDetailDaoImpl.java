package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzfh.service.employee.dao.DeptYearNeedDetailDao;
import com.hzfh.service.employee.mapper.DeptYearNeedDetailMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("deptYearNeedDetailDao")
public class DeptYearNeedDetailDaoImpl extends BaseDaoImpl<DeptYearNeedDetail, DeptYearNeedDetailCondition, DeptYearNeedDetailMapper> implements DeptYearNeedDetailDao {
	@Autowired
	private DeptYearNeedDetailMapper deptYearNeedDetailMapper;
	@Override
	public List<DeptYearNeedDetail> getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return deptYearNeedDetailMapper.getInfoByNeedNo(id);
	}
}