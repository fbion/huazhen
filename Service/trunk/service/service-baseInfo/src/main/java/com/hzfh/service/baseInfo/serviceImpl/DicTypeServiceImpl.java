package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzfh.api.baseInfo.service.DicTypeService;
import com.hzfh.service.baseInfo.dao.DicTypeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("dicTypeService")
public class DicTypeServiceImpl extends BaseServiceImpl<DicType, DicTypeCondition, DicTypeDao> implements DicTypeService {
}