package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.product.service.ProductService;
import com.hzfh.service.product.dao.ProductDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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


@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductCondition, ProductDao> implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getListByType(byte type)
    {
        return productDao.getListByType(type);
    }
    
    @Override
	public int updateStatus(int id, byte status) {
		return productDao.updateStatus(id,status);
	}
    
	@Override
	public int updateManager(int id, int emp) {
		  return productDao.updateManager(id,emp);
	}
	@Override
	public int updateBasicInfo(Product product) {
		  return productDao.updateBasicInfo(product);
	}

	@Override
	public int updateStatusAndTime(Product product) {
		 return productDao.updateStatusAndTime(product);
	}

	@Override
	public int updateRemain(Product product) {
		return productDao.updateRemain(product);
	}
	@Override
	public int updateReRemain(Product product) {
		return productDao.updateReRemain(product);
	}

	@Override
	public List<Product> getProductByTypeAndStatus(byte type, byte status) {
		return productDao.getProductByTypeAndStatus(type, status);
	}

    @Override
    public List<Product> getProductListWithNoPaging(ProductCondition productCondition) {
        return productDao.getProductListWithNoPaging(productCondition);
    }

    //mengchong 2015/02/28
	@Override
	public int updateStartTime(int id, Date start) {
		return productDao.updateStartTime(id,start);
	}

    @Override
    public int updateReduceRemainAmountAndRemainSmall(int id, long remainAmount) {
        return productDao.updateReduceRemainAmountAndRemainSmall(id,remainAmount);
    }

    @Override
    public int updateAddRemainAmountAndRemainSmall(int id, long remainAmount) {
        return productDao.updateAddRemainAmountAndRemainSmall(id,remainAmount);
    }

	@Override
	public List<Product> getProductListByStatus(byte statusLeft,byte statusRight) {
		return productDao.getProductListByStatus(statusLeft,statusRight);
	}

    @Override
    public int updateReduceRemainAmount(int productNo, long money) {
        return productDao.updateReduceRemainAmount(productNo,money);
    }

    @Override
    public int updateAddRemainAmount(int productNo, long money) {
        return productDao.updateAddRemainAmount(productNo,money);
    }

	@Override
	public Product getInfoByActivitiNo(String activitiNo) {
		return productDao.getInfoByActivitiNo(activitiNo);
	}
}