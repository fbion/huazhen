package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzfh.service.sales.dao.ProductTaskDao;
import com.hzfh.service.sales.mapper.ProductTaskMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("productTaskDao")
public class ProductTaskDaoImpl extends BaseDaoImpl<ProductTask, ProductTaskCondition, ProductTaskMapper> implements ProductTaskDao {

	@Autowired
	private ProductTaskMapper productTaskMapper;
	
	@Override
	public List<ProductTask> getListByProductNo(int product) {
		return productTaskMapper.getListByProductNo(product);
	}

    @Override
    public int updateStatus(ProductTask productTask){return productTaskMapper.updateStatus(productTask);}

	@Override
	public int updateAmount(ProductTask productTask) {
		return productTaskMapper.updateAmount(productTask);
	}

	@Override
	public int updateReAmount(ProductTask productTask) {
		return productTaskMapper.updateReAmount(productTask);
	}

    @Override
    public int updateAddCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        return productTaskMapper.updateAddCurrentAmount(productNo, currentAmount,deptNo);
    }

    @Override
    public int updateReduceCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        return productTaskMapper.updateReduceCurrentAmount(productNo,currentAmount,deptNo);
    }
}