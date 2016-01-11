package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzfh.api.employee.service.SubsidyTotalService;
import com.hzfh.service.employee.dao.SubsidyTotalDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("subsidyTotalService")
public class SubsidyTotalServiceImpl extends BaseServiceImpl<SubsidyTotal, SubsidyTotalCondition, SubsidyTotalDao> implements SubsidyTotalService {
    @Autowired
    private SubsidyTotalDao subsidyTotalDao;
    @Override
    public int updateIsExamineById(int id){
        return subsidyTotalDao.updateIsExamineById(id);
    }
	@Override
	public List<SubsidyTotal> getListForExcel(
			SubsidyTotalCondition subsidyTotalCondition) {
		// TODO Auto-generated method stub
		return subsidyTotalDao.getListForExcel(subsidyTotalCondition);
	}
}