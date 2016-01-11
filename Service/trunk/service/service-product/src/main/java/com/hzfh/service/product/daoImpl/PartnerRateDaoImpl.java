package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzfh.service.product.dao.PartnerRateDao;
import com.hzfh.service.product.mapper.PartnerRateMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("partnerRateDao")
public class PartnerRateDaoImpl extends BaseDaoImpl<PartnerRate, PartnerRateCondition, PartnerRateMapper> implements PartnerRateDao {
	@Autowired
	private PartnerRateMapper partnerRateMapper;
	
	@Override
	public PartnerRate getPartnerRate(int productNo, Long money) {
		return partnerRateMapper.getPartnerRate(productNo, money);
	}

	@Override
	public List<PartnerRate> getListByProductNo(int productNo) {
		return partnerRateMapper.getListByProductNo(productNo);
	}
}