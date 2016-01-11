package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzfh.api.sales.service.ProductTaskService;
import com.hzfh.service.sales.dao.ProductTaskDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("productTaskService")
public class ProductTaskServiceImpl extends BaseServiceImpl<ProductTask, ProductTaskCondition, ProductTaskDao> implements ProductTaskService {
	
	@Autowired
	private ProductTaskDao productTaskDao;
	
	@Override
	public List<ProductTask> getListByProductNo(int product) {
		return productTaskDao.getListByProductNo(product);
	}

    @Override
    public int updateStatus(ProductTask productTask){return productTaskDao.updateStatus(productTask);}

	@Override
	public int updateAmount(ProductTask productTask) {
		return productTaskDao.updateAmount(productTask);
	}

	@Override
	public int updateReAmount(ProductTask productTask) {
		return productTaskDao.updateReAmount(productTask);
	}

    @Override
    public int updateAddCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        return productTaskDao.updateAddCurrentAmount(productNo, currentAmount,deptNo);
    }

    @Override
    public int updateReduceCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        return productTaskDao.updateReduceCurrentAmount(productNo,currentAmount,deptNo);
    }
}