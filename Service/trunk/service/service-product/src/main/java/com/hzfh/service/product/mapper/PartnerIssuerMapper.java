package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("partnerIssuerMapper")
public interface PartnerIssuerMapper extends BaseMapper<PartnerIssuer, PartnerIssuerCondition> {
}