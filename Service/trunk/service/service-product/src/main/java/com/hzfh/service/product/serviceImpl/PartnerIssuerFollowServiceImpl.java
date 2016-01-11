package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzfh.api.product.service.PartnerIssuerFollowService;
import com.hzfh.service.product.dao.PartnerIssuerFollowDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("partnerIssuerFollowService")
public class PartnerIssuerFollowServiceImpl extends BaseServiceImpl<PartnerIssuerFollow, PartnerIssuerFollowCondition, PartnerIssuerFollowDao> implements PartnerIssuerFollowService {
}