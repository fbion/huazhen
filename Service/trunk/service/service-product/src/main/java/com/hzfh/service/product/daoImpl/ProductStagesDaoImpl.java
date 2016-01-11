package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzfh.service.product.dao.ProductStagesDao;
import com.hzfh.service.product.mapper.ProductStagesMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("productStagesDao")
public class ProductStagesDaoImpl extends BaseDaoImpl<ProductStages, ProductStagesCondition, ProductStagesMapper> implements ProductStagesDao {
	@Autowired
	private ProductStagesMapper productStagesMapper;
	
	@Override
	public Integer getProductMaxStage(int product_no) {
		return productStagesMapper.getProductMaxStage(product_no);
	}

	@Override
	public int getProductStageId(int product_no, int stagesNumber) {
		return productStagesMapper.getProductStageId(product_no,stagesNumber);
	}
}