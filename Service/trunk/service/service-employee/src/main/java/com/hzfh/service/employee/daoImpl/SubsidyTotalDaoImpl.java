package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzfh.service.employee.dao.SubsidyTotalDao;
import com.hzfh.service.employee.mapper.SubsidyTotalMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("subsidyTotalDao")
public class SubsidyTotalDaoImpl extends BaseDaoImpl<SubsidyTotal, SubsidyTotalCondition, SubsidyTotalMapper> implements SubsidyTotalDao {
    @Autowired
    private SubsidyTotalMapper subsidyTotalMapper;
    @Override
    public int updateIsExamineById(int id){
        return subsidyTotalMapper.updateIsExamineById(id);
    }
	@Override
	public List<SubsidyTotal> getListForExcel(
			SubsidyTotalCondition subsidyTotalCondition) {
		// TODO Auto-generated method stub
		return subsidyTotalMapper.getListForExcel(subsidyTotalCondition);
	}
}