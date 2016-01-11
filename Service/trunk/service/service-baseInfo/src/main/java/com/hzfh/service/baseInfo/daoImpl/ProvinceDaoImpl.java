package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
import com.hzfh.service.baseInfo.dao.ProvinceDao;
import com.hzfh.service.baseInfo.mapper.ProvinceMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("provinceDao")
public class ProvinceDaoImpl extends BaseDaoImpl<Province, ProvinceCondition, ProvinceMapper> implements ProvinceDao {
    @Autowired
    private ProvinceMapper provinceMapper;
	@Override
	public List<Province> getListByEnabled(byte enabled) {
		// TODO Auto-generated method stub
		return provinceMapper.getListByEnabled(enabled);
	}
}