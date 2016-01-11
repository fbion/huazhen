package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzframework.data.service.BaseService;

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


public interface DicDataService extends BaseService<DicData, DicDataCondition> {
	public List<DicData> getDicDataListByType(int dicTypeNo);
    public DicData getDicDataByTypeAndCode(int dicTypeNo,int code);
	public DicData getCodeByTypeNoAndName(int typeNo, String name);
}