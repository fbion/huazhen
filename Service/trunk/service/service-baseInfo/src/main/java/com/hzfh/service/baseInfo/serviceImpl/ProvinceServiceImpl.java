package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
import com.hzfh.api.baseInfo.service.ProvinceService;
import com.hzfh.service.baseInfo.dao.ProvinceDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("provinceService")
public class ProvinceServiceImpl extends BaseServiceImpl<Province, ProvinceCondition, ProvinceDao> implements ProvinceService {
	@Autowired
    private ProvinceDao provinceDao;
	@Override
	public List<Province> getListByEnabled(byte enabled) {
		
		return provinceDao.getListByEnabled(enabled);
	}
}