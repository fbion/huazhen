package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzfh.api.product.service.ProductStagesService;
import com.hzfh.service.product.dao.ProductStagesDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("productStagesService")
public class ProductStagesServiceImpl extends BaseServiceImpl<ProductStages, ProductStagesCondition, ProductStagesDao> implements ProductStagesService {

	@Autowired
	private ProductStagesDao productStagesDao;
	@Override
	public Integer getProductMaxStage(int product_no) {
		return productStagesDao.getProductMaxStage(product_no);
	}
	@Override
	public int getProductStageId(int product_no, int stagesNumber) {
		return productStagesDao.getProductStageId(product_no,stagesNumber);
	}
}