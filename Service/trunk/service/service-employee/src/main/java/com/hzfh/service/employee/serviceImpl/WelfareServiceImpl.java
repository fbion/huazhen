package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Welfare;
import com.hzfh.api.employee.model.query.WelfareCondition;
import com.hzfh.api.employee.service.WelfareService;
import com.hzfh.service.employee.dao.WelfareDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("welfareService")
public class WelfareServiceImpl extends BaseServiceImpl<Welfare, WelfareCondition, WelfareDao> implements WelfareService {
}