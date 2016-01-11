package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzfh.service.baseInfo.dao.DicTypeDao;
import com.hzfh.service.baseInfo.mapper.DicTypeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

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


@Service("dicTypeDao")
public class DicTypeDaoImpl extends BaseDaoImpl<DicType, DicTypeCondition, DicTypeMapper> implements DicTypeDao {
}