package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.api.baseInfo.service.DicDataService;
import com.hzfh.service.baseInfo.dao.DicDataDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("dicDataService")
public class DicDataServiceImpl extends BaseServiceImpl<DicData, DicDataCondition, DicDataDao> implements DicDataService {
	@Autowired
	private DicDataDao dicDataDao;
		
	@Override
	public List<DicData> getDicDataListByType(int dicTypeNo) {
		return dicDataDao.getDicDataListByType(dicTypeNo);
	}

    @Override
    public DicData getDicDataByTypeAndCode(int dicTypeNo, int code) {
        return dicDataDao.getDicDataByTypeAndCode(dicTypeNo,code);
    }

	@Override
	public DicData getCodeByTypeNoAndName(int typeNo, String name) {
		// TODO Auto-generated method stub
		return dicDataDao.getCodeByTypeNoAndName(typeNo,name);
	}


}