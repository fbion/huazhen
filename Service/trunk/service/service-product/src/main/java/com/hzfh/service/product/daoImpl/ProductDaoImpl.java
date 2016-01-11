package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.service.product.dao.ProductDao;
import com.hzfh.service.product.mapper.ProductMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/8
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


@Service("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product, ProductCondition, ProductMapper> implements ProductDao {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getListByType(byte type) {
        return productMapper.getListByType(type);
    }

    @Override
    public int updateManager(int id, int emp) {
        return productMapper.updateManager(id, emp);
    }

    @Override
    public int updateBasicInfo(Product product) {
        return productMapper.updateBasicInfo(product);
    }

    @Override
    public int updateStatus(int id, byte status) {
        return productMapper.updateStatus(id, status);
    }

    @Override
    public int updateStatusAndTime(Product product) {
        return productMapper.updateStatusAndTime(product);
    }

    @Override
    public int updateRemain(Product product) {
        return productMapper.updateRemain(product);
    }

    @Override
	public int updateReRemain(Product product) {
		return productMapper.updateReRemain(product);
	}
    
    @Override
    public List<Product> getProductByTypeAndStatus(byte type, byte status) {
        return productMapper.getProductByTypeAndStatus(type, status);
    }

    @Override
    public List<Product> getProductListWithNoPaging(ProductCondition productCondition) {
        return productMapper.getProductListWithNoPaging(productCondition);
    }

	@Override
	public int updateStartTime(int id, Date start) {
		
		return productMapper.updateStartTime(id,start);
	}

    @Override
    public int updateAddRemainAmountAndRemainSmall(int id, long remainAmount) {
        return productMapper.updateAddRemainAmountAndRemainSmall(id,remainAmount);
    }

    @Override
    public int updateReduceRemainAmountAndRemainSmall(int id, long remainAmount) {
        return productMapper.updateReduceRemainAmountAndRemainSmall(id,remainAmount);
    }

	@Override
	public List<Product> getProductListByStatus(byte statusLeft,byte statusRight) {
		return productMapper.getProductListByStatus(statusLeft,statusRight);
	}

    @Override
    public int updateReduceRemainAmount(int productNo, long money) {
        return productMapper.updateReduceRemainAmount(productNo,money);
    }

    @Override
    public int updateAddRemainAmount(int productNo, long money) {
        return productMapper.updateAddRemainAmount(productNo,money);
    }

    @Override
    public Product getInfoByActivitiNo(String activitiNo) {
        return productMapper.getInfoByActivitiNo(activitiNo);
    }
}