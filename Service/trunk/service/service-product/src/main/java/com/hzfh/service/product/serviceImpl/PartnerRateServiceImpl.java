package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzfh.api.product.service.PartnerRateService;
import com.hzfh.service.product.dao.PartnerRateDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("partnerRateService")
public class PartnerRateServiceImpl extends BaseServiceImpl<PartnerRate, PartnerRateCondition, PartnerRateDao> implements PartnerRateService {
	@Autowired
	private PartnerRateDao partnerRateDao;
	@Override
	public PartnerRate getPartnerRate(int productNo, Long money) {
		return partnerRateDao.getPartnerRate(productNo,money);
	}
	@Override
	public List<PartnerRate> getListByProductNo(int productNo) {
		return partnerRateDao.getListByProductNo(productNo);
	}
}