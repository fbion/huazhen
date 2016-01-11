package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("productMapper")
public interface ProductMapper extends BaseMapper<Product, ProductCondition> {
    public List<Product> getListByType(byte type);

	public int updateStatus(int id,byte aa);

	public int updateManager(int id,int emp);

	public int updateBasicInfo(Product product);

	public int updateStatusAndTime(Product product);

	public int updateRemain(Product product);
	
	public int updateReRemain(Product product);

	public List<Product> getProductByTypeAndStatus(@Param("type")byte type, @Param("status")byte status);

    public List<Product> getProductListWithNoPaging(ProductCondition productCondition);

	public int updateStartTime(@Param("id")int id,@Param("start") Date start);

    int updateReduceRemainAmountAndRemainSmall(@Param("id")int id,@Param("remainAmount") long remainAmount);

    int updateAddRemainAmountAndRemainSmall(@Param("id")int id,@Param("remainAmount") long remainAmount);

	public List<Product> getProductListByStatus(@Param("statusLeft")byte statusLeft,@Param("statusRight")byte statusRight);

    public int updateReduceRemainAmount(@Param("id")int productNo, @Param("money")long money);

    public int updateAddRemainAmount(@Param("id")int productNo, @Param("money")long money);

	Product getInfoByActivitiNo(@Param("activitiNo")String activitiNo);
}