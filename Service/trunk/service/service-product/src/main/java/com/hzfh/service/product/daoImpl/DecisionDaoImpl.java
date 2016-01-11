package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzfh.service.product.dao.DecisionDao;
import com.hzfh.service.product.mapper.DecisionMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("decisionDao")
public class DecisionDaoImpl extends BaseDaoImpl<Decision, DecisionCondition, DecisionMapper> implements DecisionDao {

	@Autowired
	private DecisionMapper decisionMapper;
	@Override
	public List<Decision> getListByProductNo(int productNo) {
		return decisionMapper.getListByProductNo(productNo);
	}
}