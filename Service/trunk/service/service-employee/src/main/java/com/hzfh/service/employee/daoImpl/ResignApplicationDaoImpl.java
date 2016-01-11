package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzfh.service.employee.dao.ResignApplicationDao;
import com.hzfh.service.employee.mapper.ResignApplicationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("resignApplicationDao")
public class ResignApplicationDaoImpl extends BaseDaoImpl<ResignApplication, ResignApplicationCondition, ResignApplicationMapper> implements ResignApplicationDao {
}