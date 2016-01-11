package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzfh.api.product.service.PartnerIssuerService;
import com.hzfh.service.product.dao.PartnerIssuerDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("partnerIssuerService")
public class PartnerIssuerServiceImpl extends BaseServiceImpl<PartnerIssuer, PartnerIssuerCondition, PartnerIssuerDao> implements PartnerIssuerService {
}