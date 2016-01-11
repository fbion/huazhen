package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("partnerIssuerFollowMapper")
public interface PartnerIssuerFollowMapper extends BaseMapper<PartnerIssuerFollow, PartnerIssuerFollowCondition> {
}