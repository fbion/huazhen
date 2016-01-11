package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzfh.api.product.service.DecisionService;
import com.hzfh.service.product.dao.DecisionDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("decisionService")
public class DecisionServiceImpl extends BaseServiceImpl<Decision, DecisionCondition, DecisionDao> implements DecisionService {
	@Autowired
	private DecisionDao decisionDao;
	
	@Override
	public List<Decision> getListByProductNo(int productNo) {
		return decisionDao.getListByProductNo(productNo);
	}
}