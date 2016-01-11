package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzfh.service.product.dao.PartnerIssuerFollowDao;
import com.hzfh.service.product.mapper.PartnerIssuerFollowMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("partnerIssuerFollowDao")
public class PartnerIssuerFollowDaoImpl extends BaseDaoImpl<PartnerIssuerFollow, PartnerIssuerFollowCondition, PartnerIssuerFollowMapper> implements PartnerIssuerFollowDao {
}