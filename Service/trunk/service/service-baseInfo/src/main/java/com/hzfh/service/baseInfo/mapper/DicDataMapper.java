package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("dicDataMapper")
public interface DicDataMapper extends BaseMapper<DicData, DicDataCondition> {
	public List getDicDataListByType(int dicTypeNo);

    public DicData getDicDataByTypeAndCode(@Param("dicTypeNo")int dicTypeNo,@Param("code")int code);

	public DicData getCodeByTypeNoAndName(@Param("dicTypeNo")int typeNo, @Param("value")String name);
}