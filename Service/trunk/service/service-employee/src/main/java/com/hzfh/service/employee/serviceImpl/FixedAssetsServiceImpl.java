package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.api.employee.service.FixedAssetsService;
import com.hzfh.service.employee.dao.FixedAssetsDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("fixedAssetsService")
public class FixedAssetsServiceImpl extends BaseServiceImpl<FixedAssets, FixedAssetsCondition, FixedAssetsDao> implements FixedAssetsService {
}