package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.service.baseInfo.dao.DicDataDao;
import com.hzfh.service.baseInfo.mapper.DicDataMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("dicDataDao")
public class DicDataDaoImpl extends BaseDaoImpl<DicData, DicDataCondition, DicDataMapper> implements DicDataDao {

	@Autowired
	private DicDataMapper dicDatamapper;
	@Override
	public List getDicDataListByType(int dicTypeNo) {
		return dicDatamapper.getDicDataListByType(dicTypeNo);
	}

    @Override
    public DicData getDicDataByTypeAndCode(int dicTypeNo, int code) {
        return dicDatamapper.getDicDataByTypeAndCode(dicTypeNo,code);
    }

	@Override
	public DicData getCodeByTypeNoAndName(int typeNo, String name) {
		// TODO Auto-generated method stub
		return dicDatamapper.getCodeByTypeNoAndName(typeNo,name);
	}
}