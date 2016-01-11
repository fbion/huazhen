package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzfh.service.product.dao.PartnerIssuerDao;
import com.hzfh.service.product.mapper.PartnerIssuerMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("partnerIssuerDao")
public class PartnerIssuerDaoImpl extends BaseDaoImpl<PartnerIssuer, PartnerIssuerCondition, PartnerIssuerMapper> implements PartnerIssuerDao {
}