package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.service.employee.dao.FixedAssetsDao;
import com.hzfh.service.employee.mapper.FixedAssetsMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("fixedAssetsDao")
public class FixedAssetsDaoImpl extends BaseDaoImpl<FixedAssets, FixedAssetsCondition, FixedAssetsMapper> implements FixedAssetsDao {
}