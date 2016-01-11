package com.hzfh.api.product.service;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

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


public interface PartnerRateService extends BaseService<PartnerRate, PartnerRateCondition> {

	PartnerRate getPartnerRate(int productNo, Long money);

	List<PartnerRate> getListByProductNo(int productNo);
}