package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("decisionMapper")
public interface DecisionMapper extends BaseMapper<Decision, DecisionCondition> {
	List<Decision> getListByProductNo(int productNo);
}