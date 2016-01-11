package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface ProductTaskService extends BaseService<ProductTask, ProductTaskCondition> {
	List<ProductTask> getListByProductNo(int product);

    int updateStatus(ProductTask productTask);

	int updateAmount(ProductTask productTask);

	int updateReAmount(ProductTask productTask);

    int updateAddCurrentAmount(int productNo, Long currentAmount, int deptNo);

    int updateReduceCurrentAmount(int productNo, Long currentAmount, int deptNo);
}