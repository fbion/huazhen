package com.hzfh.api.product.service;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzframework.data.service.BaseService;

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


public interface ProductStagesService extends BaseService<ProductStages, ProductStagesCondition> {

	Integer getProductMaxStage(int product_no);

	int getProductStageId(int product_no, int stagesNumber);
}