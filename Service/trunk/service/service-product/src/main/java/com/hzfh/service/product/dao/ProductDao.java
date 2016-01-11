package com.hzfh.service.product.dao;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ProductDao extends BaseDao<Product, ProductCondition> {
	public List<Product> getListByType(byte type);

	public int updateStatus(int id, byte status);

	public int updateManager(int id, int emp);

	public int updateBasicInfo(Product product);

	public int updateStatusAndTime(Product product);

	public int updateRemain(Product product);

	public int updateReRemain(Product product);
	
	public List<Product> getProductByTypeAndStatus(byte type, byte status);

    public List<Product> getProductListWithNoPaging(ProductCondition productCondition);

	public int updateStartTime(int id, Date start);

    public int updateAddRemainAmountAndRemainSmall(int id, long remainAmount);

    public int updateReduceRemainAmountAndRemainSmall(int id, long remainAmount);

	public List<Product> getProductListByStatus(byte statusLeft,byte statusRight);

    public int updateReduceRemainAmount(int productNo, long money);

    public int updateAddRemainAmount(int productNo, long money);

	Product getInfoByActivitiNo(String activitiNo);
}